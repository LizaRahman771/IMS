package com.Loddo.InventoryMgtSystem.config;

import com.Loddo.InventoryMgtSystem.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String identifier = authentication.getName(); // This will be the Email
        String password = authentication.getCredentials().toString();

        // Find user by email in MongoDB
        return userRepository.findByEmail(identifier)
                .map(user -> {
                    // Verify hashed password using the PasswordEncoder bean from SecurityConfig
                    if (passwordEncoder.matches(password, user.getPassword())) {
                        Set<GrantedAuthority> authorities = new HashSet<>();
                        // Add ROLE_ prefix as required by Spring Security
                        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

                        return new UsernamePasswordAuthenticationToken(identifier, password, authorities);
                    } else {
                        throw new BadCredentialsException("Invalid password");
                    }
                })
                .orElseThrow(() -> new BadCredentialsException("Invalid Email or password"));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

