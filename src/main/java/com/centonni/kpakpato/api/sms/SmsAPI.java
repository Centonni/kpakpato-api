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
public interface SmsAPI {

    AuthenticationToken getToken();

    boolean sendSms(MessageContext message,String receiverAdress);

    boolean sendSms(MessageContext message, String... receiverAdress);
}
