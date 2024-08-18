package com.ychs.lawfirmsys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/23
 */
@Configuration
public class BeanConfiguration {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}


