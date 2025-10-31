package com.sumanth.fundamentals_of_springboot.project2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests((auth)->{
                    auth.requestMatchers(HttpMethod.POST,"/api/**").hasAnyRole("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT,"/api/**").hasAnyRole("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/**").hasAnyRole("ADMIN");
                    auth.requestMatchers(HttpMethod.PATCH,"/api/**").hasAnyRole("ADMIN","USER");
                    auth.requestMatchers(HttpMethod.GET,"/api/**").permitAll();


                    auth.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    //Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    //multiple user
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails Sanjay = User.builder()
                .username("Sanjay")
                .password(passwordEncoder().encode("sanjay"))
                .roles("USER")
                .build();

        UserDetails Pradeep = User.builder()
                .username("Pradeep")
                .password(passwordEncoder().encode("pradeep"))
                .roles("USER")
                .build();

        UserDetails Admin = User.builder()
                .username("Admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(Sanjay,Pradeep,Admin);

    }

}
