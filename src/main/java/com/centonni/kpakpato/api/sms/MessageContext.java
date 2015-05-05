/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centonni.kpakpato.api.sms;

/**
 *
 * @author Komi Serge Innocent <komi.innocent@gmail.com>
 */
public class MessageContext {

    private String senderAdress;
    private String senderName;
    private String message; 

    public MessageContext(String senderAdress, String senderName, String message) {
        this.senderAdress = senderAdress;
        this.senderName = senderName;
        this.message = message; 
    }

    public String getSenderAdress() {
        return senderAdress;
    }

    public void setSenderAdress(String senderAdress) {
        this.senderAdress = senderAdress;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
 
}
