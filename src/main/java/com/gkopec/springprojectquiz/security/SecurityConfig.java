package com.gkopec.springprojectquiz.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


    //tworzę użytownika
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails USER =  User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        UserDetails ADMIN =  User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(USER, ADMIN);
    }



    //aplikacja sprawdza uprawnienia użtkownika dla każdego żądania
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "index.jsp", "index", "/").permitAll()
                .antMatchers("/solveQuiz").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/result").hasRole("USER")
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();



    }
}
