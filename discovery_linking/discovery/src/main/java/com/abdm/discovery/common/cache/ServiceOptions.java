package com.abdm.discovery.common.cache;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "gateway.serviceoptions")
@Data
public class ServiceOptions {
    public int timeout;
    public String registryPath;
    public int responseMaxRetryAttempts;
    public int retryAttemptsDelay;

    // Default no-arg constructor required for @ConfigurationProperties
    public ServiceOptions() {
        }
    public int getTimeout() {
        return timeout;
    }
}
