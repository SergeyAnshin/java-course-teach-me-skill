package com.ans.serg.restsecurity.configuration;

import com.ans.serg.restsecurity.configuration.jwt.JWTConfiguration;
import com.ans.serg.restsecurity.entity.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String ADMIN_ENDPOINT_PATTERN = "/admin/**";
    private JWTConfiguration jwtConfiguration;

    public SpringSecurityConfiguration(JWTConfiguration jwtConfiguration) {
        this.jwtConfiguration = jwtConfiguration;
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                    .antMatchers("/user/**").permitAll()
                    .antMatchers(ADMIN_ENDPOINT_PATTERN).hasAuthority(UserRole.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .apply(jwtConfiguration);
        http
                .headers().frameOptions().sameOrigin();
    }
}
