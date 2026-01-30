package com.example.project.config;

import org.springframework.context.annotation.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatchers;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

       RequestMatcher apiMatcher =  AntPathRequestMatcher.antMatcher("/api/**");
      

          
        http
            .csrf(csrf -> csrf.ignoringRequestMatchers(apiMatcher))
            .authorizeHttpRequests(auth -> auth 
                        .requestMatchers("/auth/login","/auth/join","/api/v1/auth/login","/api/v1/auth/join","/api/v1/auth/**").permitAll()
                         .requestMatchers("/").permitAll()
                          .anyRequest().authenticated()
            )
            .formLogin(login -> login.disable())
            .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}    
