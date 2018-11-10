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
 * A wrapper class that contain informations about the sms that will be sent
 * 
 * @author Komi Serge Innocent 
 */
public class MessageContext {

    private String senderAdress;
    private String senderName;
    private String message; 

    /**
     * Create an instance of {@link MessageContext}     * 
     * @param senderAdress the sender address in the format tel:+225number
     * @param senderName the sender name to display to receiver
     * @param message the content of your message
     */
    public MessageContext(String senderAdress, String senderName, String message) {
        this.senderAdress = "tel:+"+senderAdress;
        this.senderName = senderName;
        this.message = message; 
    }

    public String getSenderAdress() {
        return senderAdress;
    }

    public void setSenderAdress(String senderAdress) {
        this.senderAdress = "tel:+"+senderAdress;
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
