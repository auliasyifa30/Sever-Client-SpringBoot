/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dtos;

import java.util.Collection;
import static net.bytebuddy.matcher.ElementMatchers.any;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author ROG
 */
public class UserSessionDTO {
    private String userName;
    private Collection<GrantedAuthority> grantedAuthorities;

    public UserSessionDTO(String userName, Collection<GrantedAuthority> grantedAuthorities) {
        this.userName = userName;
        this.grantedAuthorities = grantedAuthorities;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(Collection<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }
    
    
}
