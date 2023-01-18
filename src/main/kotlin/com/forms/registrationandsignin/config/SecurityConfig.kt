package com.forms.registrationandsignin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun filterChain(httpSecurity:HttpSecurity):SecurityFilterChain{
        return httpSecurity
            .authorizeRequests()
            .antMatchers("/**")
            .permitAll()
            .and()
            .build()
    }
}