package com.Loddo.InventoryMgtSystem.config;

import com.Loddo.InventoryMgtSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserRepository userRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Publicly accessible resources
                        .requestMatchers("/register", "/login", "/css/**", "/js/**", "/images/**").permitAll()

                        // Roles updated based on Project Plan Section 4.1
                        // Suppliers manage overall availability and high-level forecasting
                        .requestMatchers("/supplier/**", "/api/forecast/supplier/**").hasRole("SUPPLIER")

                        // Sellers manage local inventory and receive product-level predictions
                        .requestMatchers("/sell/**", "/api/forecast/seller/**").hasRole("SELLER")

                        // Common dashboard and general prediction tools for both roles
                        .requestMatchers("/dashboard/**", "/api/forecast/**").hasAnyRole("SUPPLIER", "SELLER")

                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/dashboard", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    /**
     * Standard encoder for securing passwords in the User model.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configured to use the specific SUPPLIER/SELLER roles from the User model.
     * Based on Project Plan Section 4.1.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return email -> userRepository.findByEmail(email)
                .map(user -> org.springframework.security.core.userdetails.User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        // user.getRole() must return the name of the Enum (SUPPLIER or SELLER)
                        .roles(user.getRole().name())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }}