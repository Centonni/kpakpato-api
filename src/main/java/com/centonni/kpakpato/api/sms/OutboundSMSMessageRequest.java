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
class OutboundSMSMessageRequest {
    private String address;
    private OutboundSMSTextMessage outboundSMSTextMessage;
    private String senderAddress;
    private String senderName;

    public OutboundSMSMessageRequest() {
    }

        
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OutboundSMSTextMessage getOutboundSMSTextMessage() {
        return outboundSMSTextMessage;
    }

    public void setOutboundSMSTextMessage(OutboundSMSTextMessage outboundSMSTextMessage) {
        this.outboundSMSTextMessage = outboundSMSTextMessage;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    
    
    
}
