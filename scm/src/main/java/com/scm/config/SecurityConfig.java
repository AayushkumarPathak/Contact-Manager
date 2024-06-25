package com.scm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
   
    // UserDetails user1 = User.
    // withDefaultPasswordEncoder().
    // username("admin123").
    // password("admin123").
    // roles("ADMIN").build();
    
    // UserDetails user2 = User.
    // withDefaultPasswordEncoder().
    // username("user123").
    // password("user123").
    // roles("USER").build();


    // @Bean
    // public UserDetailsService userDetailsService() {
    //    var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1);
    //    return inMemoryUserDetailsManager;
    // }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(null);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
