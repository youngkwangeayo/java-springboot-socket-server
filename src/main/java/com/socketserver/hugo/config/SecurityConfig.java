package com.socketserver.hugo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
                
      
                http.csrf(csrf -> csrf.disable());
                http
                        .authorizeHttpRequests((authorize)->authorize
                                // .requestMatchers("/member/**").authenticated() // restfull / member 이후로는 인증필요
                                // .requestMatchers("/admin/**").hasRole("ADMIN") // 어드민은 어드민이상만
                                .anyRequest().permitAll() //그이후 요청은 모두 가능
                        );
                        
                        
                        
                     
                

                return http.build();
        }
}
