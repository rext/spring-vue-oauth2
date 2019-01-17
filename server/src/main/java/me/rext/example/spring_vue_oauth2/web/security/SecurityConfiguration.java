package me.rext.example.spring_vue_oauth2.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private Environment env;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser(env.getRequiredProperty("security.user.name"))
                .password(passwordEncoder.encode(env.getRequiredProperty("security.user.password")))
                .authorities(env.getRequiredProperty("security.user.role"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/login", "/logout", "/webjars/**", "/sys/**", "/oauth/authorize")
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/logout").fullyAuthenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .permitAll(false);
    }
}
