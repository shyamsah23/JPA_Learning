package com.Learner.hospitalManagement.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())  // disable CSRF for APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/dummy").permitAll()
                        .requestMatchers("/auth/login").permitAll()
                        .anyRequest().authenticated()   // allow others only if logged in
                )
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable()); // disable basic auth

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
