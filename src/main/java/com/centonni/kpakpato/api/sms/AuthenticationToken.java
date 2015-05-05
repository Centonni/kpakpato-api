/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centonni.kpakpato.api.sms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

/**
 *
 * @author Komi Serge Innocent <komi.innocent@gmail.com>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationToken {
    private String token_type;
    private String access_token;
    private Integer expires_in;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
    
    public String getAuthorization(){
        return token_type+" "+access_token;
    }
    
    public Date getExpireDate(){
        return new Date(new Long(expires_in));
    }

    @Override
    public String toString() {
        return "AuthenticationToken{" + "token_type=" + token_type + ", access_token=" + access_token + ", expires_in=" + expires_in + '}';
    }
    
    
    
}
