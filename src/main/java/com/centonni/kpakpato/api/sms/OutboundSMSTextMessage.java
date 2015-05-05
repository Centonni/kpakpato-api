/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centonni.kpakpato.api.sms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Komi Serge Innocent <komi.innocent@gmail.com>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class OutboundSMSTextMessage {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
     
}
