/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.centonni.kpakpato.api.sms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

/**
 * This class contain the authorization informations retrieved with the client credentials.
 *  
 * @author Komi Serge Innocent 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AuthenticationToken {
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
    
    /**
     * 
     * @return the {@link  Date} the authorization token will expire.
     */
    public Date getExpireDate(){
        return new Date(new Long(expires_in));
    }

    @Override
    public String toString() {
        return "AuthenticationToken{" + "token_type=" + token_type + ", access_token=" + access_token + ", expires_in=" + expires_in + '}';
    }
    
    
    
}
