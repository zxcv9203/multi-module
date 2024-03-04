package org.example.core.infrastructure.repository;

import org.example.core.infrastructure.repository.model.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<MemberJpaEntity, Long> {
}
