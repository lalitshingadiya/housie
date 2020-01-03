package com.game.housie.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler  {
	
	  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,Authentication authentication) throws IOException, ServletException {
		
		  boolean isUser = false;
	        boolean isAdmin = false;
	        String targetUrl="";
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	        for (GrantedAuthority grantedAuthority : authorities) {
	        	if ("USER".equalsIgnoreCase(grantedAuthority.getAuthority())) {
	                isUser = true;
	                break;
	            } else if ("ADMIN".equalsIgnoreCase(grantedAuthority.getAuthority())) {
	                isAdmin = true;
	                break;
	            }
	        }
	 
	        if (isUser) {
	        	targetUrl="/welcome";
	        } else if (isAdmin) {
	        	targetUrl="/admin";
	        } else {
	            throw new IllegalStateException();
	        }

	        redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	  public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	        this.redirectStrategy = redirectStrategy;
	    }
	    protected RedirectStrategy getRedirectStrategy() {
	        return redirectStrategy;
	    }

}
