package com.in28.minutes.springboot.myfirstspringweb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration // 빈 만들 때
public class SpringSecurityConfiguration {

    // 사용자 정보 관리 메서드
    @Bean
    public InMemoryUserDetailsManager createUserDatailsManager() {
        // 암호화 과정
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails userDetails1 = createNewUser(passwordEncoder, "kim", "11");
        UserDetails userDetails2 = createNewUser(passwordEncoder, "kim1", "11");

        // 메모리에 사용자 정보를 저장하고 관리
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(Function<String, String> passwordEncoder, String kim, String password) {
        UserDetails userDetails =
                User.builder() // 유저 생성, 이름, 암호, 역할 설정
                        .passwordEncoder(passwordEncoder)
                        .username(kim)
                        .password(password)
                        .roles("user", "admin")
                        .build();
        return userDetails;
    }

    // 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean // 웹 요청이 들어오면 제일 먼저 실행
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // HttpSecurity : 웹 기반 보안 관리
        // authorizeHttpRequests() : HTTP 요청에 대한 인가 설정
        // build() : HttpSecurity를 기반으로 SecurityFilterChain을 생성하여 반환
        http.authorizeHttpRequests(
            auth -> auth.anyRequest().authenticated());

        // 만약 승인되지 않은 요청이 있다면
        http.formLogin(withDefaults());
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }
}
