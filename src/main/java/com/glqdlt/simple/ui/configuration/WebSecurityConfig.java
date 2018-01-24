package com.glqdlt.simple.ui.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Value("${def.user.id}")
    private String USER_ID;

    @Value("${def.user.pw}")
    private String PASSWORD;

    private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/**").hasAnyRole("admin")
                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/auth/login")
                .loginProcessingUrl("/auth/login")
                .usernameParameter("id")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .permitAll();

        http
                .logout()
                .logoutUrl("/auth/logout")
                .logoutSuccessUrl("/auth/login")
                .permitAll();

        http
                .sessionManagement()
                .maximumSessions(1);

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**");
//                .and().ignoring().antMatchers("/api/**");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication().withUser(USER_ID).password(PASSWORD).roles("admin");
    }

}
