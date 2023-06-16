package com.synchrony.project.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/api/**").authenticated()
                .and()
                .oauth2Login()
                .and()
                .oauth2Client();
    }
}

