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

/**
 * Interface that provide methods for dealing with sms provider apis
 * 
 * @author Komi Serge Innocent 
 */
public interface SmsAPI {

    /**
     * This method should return an instance of {@link AuthenticationToken} that basically contain
     * the authorization token to acces the provider Api
     * @see AuthenticationToken
     * @return 
     */
    AuthenticationToken getToken();

    /**
     * This method executes a request to the sms provider api to send message to a receiver
     * @see MessageContext
     * @param message the content of the message to send
     * @param receiverAdress the receiver address in the format tel:+225number
     * @return true if the sms was send succesfully
     */
    boolean sendSms(MessageContext message,String receiverAdress);

    /**
     * This method executes a request to the sms provider api to send message to a list of receiver
     * @see MessageContext
     * @param message the content of the message to send
     * @param receiverAdress the receiver address in the format tel:+225number
     * @return true if the sms was send succesfully
     */
    boolean sendSms(MessageContext message, String... receiverAdress);
}
