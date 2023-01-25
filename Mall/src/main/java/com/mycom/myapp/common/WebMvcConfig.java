package com.mycom.myapp.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/**") // '/'아래 있는 모든 것에 대해 로그인 안 되어있으면 로그인 창으로 돌아가게 해
		//.excludePathPatterns("/login/**", "/register/**"); // static folder // jsp 사용할 경우
		.excludePathPatterns("/", "/index.html", "/login.html", "/register.html") //단 이 경우를 제외하고
		.excludePathPatterns("/login/**", "/register/**", "/css/**", "/js/**", "/img/**"); // html 사용할 경우
	}
}
