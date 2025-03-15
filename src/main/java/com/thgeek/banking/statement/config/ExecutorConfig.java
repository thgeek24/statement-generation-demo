package com.thgeek.banking.statement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Configuration for Executor Pools
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 09:59
 */
@Configuration
public class ExecutorConfig {
    @Bean(name = "stmtGenExecutor")
    public Executor computeTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("StmtGenExecutor-");
        executor.initialize();
        return executor;
    }
}
