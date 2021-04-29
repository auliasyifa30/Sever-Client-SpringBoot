
package com.mii.server.dtos;

import java.util.Collection;
import java.util.List;


public class LoginDTO {
    private String userName;
    private Collection<String> authorities;;


    public LoginDTO() {
    }

    public LoginDTO(String userName, Collection<String> authorities) {
        this.userName = userName;
        this.authorities = authorities;
    }

    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<String> authorities) {
        this.authorities = authorities;
    }

    
}
