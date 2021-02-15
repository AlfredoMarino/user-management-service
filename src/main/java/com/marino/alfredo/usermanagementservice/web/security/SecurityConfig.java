package com.marino.alfredo.usermanagementservice.web.security;

import com.marino.alfredo.usermanagementservice.service.UserService;
import com.marino.alfredo.usermanagementservice.web.security.filter.JWTFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTFilterRequest jwtFilterRequest;

    private final String[] SECURE_PATHS = new String[]{
            "/**/auth/authenticate",
            "/**/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/**/swagger-ui.html",
            "/webjars/**",
            "/swagger-ui/**"
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers(SECURE_PATHS).permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
