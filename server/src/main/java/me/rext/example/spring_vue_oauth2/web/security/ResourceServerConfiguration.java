package me.rext.example.spring_vue_oauth2.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Autowired
    private Environment env;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(env.getRequiredProperty("security.oauth2.resource.id"))
                .stateless(true);

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //TODO revert API matcher
        http.antMatcher("/api1/**")
                .authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .anonymous().disable()
                .sessionManagement().disable();
    }
}
