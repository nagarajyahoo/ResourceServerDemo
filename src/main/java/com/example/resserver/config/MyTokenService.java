package com.example.resserver.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

import java.util.ArrayList;
import java.util.Collection;

public class MyTokenService extends DefaultTokenServices {
    @Override
    public OAuth2Authentication loadAuthentication(String accessTokenValue) throws AuthenticationException, InvalidTokenException {
        OAuth2Authentication oAuth2Authentication = super.loadAuthentication(accessTokenValue);
        OAuth2Request req = oAuth2Authentication.getOAuth2Request();
        Authentication userAuth = oAuth2Authentication.getUserAuthentication();
        UsernamePasswordAuthenticationToken userPassToken = new UsernamePasswordAuthenticationToken(userAuth.getPrincipal(), userAuth.getCredentials(), getAuthorities());
        OAuth2Authentication auth = new OAuth2Authentication(req, userPassToken);
        return auth;
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> permissions = new ArrayList<>();
        permissions.add(new SimpleGrantedAuthority("USER"));
        permissions.add(new SimpleGrantedAuthority("ADMIN"));
        return permissions;
    }
}
