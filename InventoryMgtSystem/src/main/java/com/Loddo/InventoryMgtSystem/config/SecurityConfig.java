package com.Loddo.InventoryMgtSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                // ✅ Phase-1 = no authentication required
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )

                // ✅ disable default login page + logout
                .formLogin(form -> form.disable())
                .logout(logout -> logout.disable());

        return http.build();
    }
}
