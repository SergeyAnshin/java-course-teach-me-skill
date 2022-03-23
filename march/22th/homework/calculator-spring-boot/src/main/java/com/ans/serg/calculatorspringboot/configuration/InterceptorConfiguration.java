package com.ans.serg.calculatorspringboot.configuration;

import com.ans.serg.calculatorspringboot.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    private AuthenticationInterceptor authenticationInterceptor;

    public InterceptorConfiguration(AuthenticationInterceptor authenticationInterceptor) {
        this.authenticationInterceptor = authenticationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/calculator/**")
                        .excludePathPatterns("/calculator/calculation")
                .addPathPatterns("/user/**")
                        .excludePathPatterns("/user/signup", "/user/login");
    }
}
