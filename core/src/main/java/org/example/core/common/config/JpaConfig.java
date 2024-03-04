package org.example.core.common.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {
        "org.example.core.infrastructure.repository"
})
@EntityScan(basePackages = {
        "org.example.core.infrastructure.repository.model"
})
public class JpaConfig {
}
