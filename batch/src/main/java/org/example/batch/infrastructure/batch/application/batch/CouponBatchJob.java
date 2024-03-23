package org.example.batch.infrastructure.batch.application.batch;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.example.core.domain.coupon.CouponStatus;
import org.example.core.infrastructure.repository.model.CouponJpaEntity;
import org.example.core.infrastructure.repository.model.MemberJpaEntity;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.time.LocalDateTime;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class CouponBatchJob {

    private static final int CHUNK_SIZE = 10;

    private final EntityManagerFactory entityManagerFactory;

    @Bean
    public Job processIssueCouponToUser(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("processIssueCouponToUser", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(issueCouponToUser(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Step issueCouponToUser(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("issueCouponToUser", jobRepository)
                .<MemberJpaEntity, CouponJpaEntity>chunk(CHUNK_SIZE, transactionManager)
                .reader(readMembersByDatabase())
                .processor(processRegisterCoupon())
                .writer(saveRegisteredCoupon())
                .build();
    }

    @Bean
    @StepScope
    public JpaPagingItemReader<MemberJpaEntity> readMembersByDatabase() {
        return new JpaPagingItemReaderBuilder<MemberJpaEntity>()
                .name("readMembersByDatabase")
                .entityManagerFactory(entityManagerFactory)
                .pageSize(CHUNK_SIZE)
                .queryString("SELECT m FROM MemberJpaEntity m")
                .build();
    }

    @Bean
    public ItemProcessor<MemberJpaEntity, CouponJpaEntity> processRegisterCoupon() {
        return member -> CouponJpaEntity.builder()
                .owner(member)
                .name(member.getName() + " " + UUID.randomUUID())
                .status(CouponStatus.CREATED)
                .startedAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plusDays(7))
                .build();
    }

    @Bean
    public ItemWriter<CouponJpaEntity> saveRegisteredCoupon() {
        return new JpaItemWriterBuilder<CouponJpaEntity>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }
}
