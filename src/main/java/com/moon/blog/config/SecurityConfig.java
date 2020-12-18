package com.moon.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration // 빈등록 (IOC 관리)
@EnableWebSecurity // 시큐리티 필터가 등록이 된다.
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests() // 요청이 들어오면
			.antMatchers("/auth/**") // /auth/ 경로로 들어오는 모든 것
			.permitAll() // 모두 허가한다.
			.anyRequest() // /auth/ 이외 모든 요청은
			.authenticated() // 인가가 되야한다.
		.and()
			.formLogin()
			.loginPage("/auth/loginForm");
	}
}
