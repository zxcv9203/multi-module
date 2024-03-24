package org.example.batch.infrastructure.batch.infrastructure.scheduler;


import lombok.RequiredArgsConstructor;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;

@RequiredArgsConstructor
public class CouponJobLauncher extends QuartzJobBean {
    private final JobLauncher jobLauncher;

    private final Job job;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addLong("time", System.currentTimeMillis());

        try {
            jobLauncher.run(job, jobParametersBuilder.toJobParameters());
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }
}
