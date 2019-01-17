package me.rext.example.spring_vue_oauth2.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfiguration {

    @Primary
    @Bean
    public AuthorizationServerTokenServices tokenServices(TokenStore tokenStore, JwtAccessTokenConverter tokenConverter) {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setTokenEnhancer(tokenConverter);
        return tokenServices;
    }

    @Bean
    TokenStore tokenStore(JwtAccessTokenConverter tokenConverter) {
        return new JwtTokenStore(tokenConverter);
    }

    @Bean
    public JwtAccessTokenConverter tokenConverter(Environment env) {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(env.getRequiredProperty("security.oauth2.signingKey"));
        return tokenConverter;
    }
}
