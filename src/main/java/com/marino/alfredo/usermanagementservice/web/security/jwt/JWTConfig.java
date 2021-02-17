package com.marino.alfredo.usermanagementservice.web.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.jwt")
public class JWTConfig {

    private String secretKey;
    private Integer tokenExpirationAfterHours;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Integer getTokenExpirationAfterHours() {
        return tokenExpirationAfterHours;
    }

    public void setTokenExpirationAfterHours(Integer tokenExpirationAfterHours) {
        this.tokenExpirationAfterHours = tokenExpirationAfterHours;
    }
}
