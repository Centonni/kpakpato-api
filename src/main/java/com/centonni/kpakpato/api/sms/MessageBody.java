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
class MessageBody {

    public MessageBody() {
    }
     
    
    private OutboundSMSMessageRequest outboundSMSMessageRequest;

    public MessageBody(OutboundSMSMessageRequest outboundSMSMessageRequest) {
        this.outboundSMSMessageRequest = outboundSMSMessageRequest;
    } 
    
    public OutboundSMSMessageRequest getOutboundSMSMessageRequest() {
        return outboundSMSMessageRequest;
    }

    public void setOutboundSMSMessageRequest(OutboundSMSMessageRequest outboundSMSMessageRequest) {
        this.outboundSMSMessageRequest = outboundSMSMessageRequest;
    }

    @Override
    public String toString() {
        return "MessageBody{" + "outboundSMSMessageRequest=" + outboundSMSMessageRequest.getSenderAddress() + '}';
    }
    
}
