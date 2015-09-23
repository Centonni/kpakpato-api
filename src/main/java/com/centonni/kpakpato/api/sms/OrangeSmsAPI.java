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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Default implementation of {@link SmsAPI} for orange ci sms api.
 *
 * @author Komi Serge Innocent 
 */
public final class OrangeSmsAPI implements SmsAPI {

    public final static String BASE_URL = "https://api.orange.com";
    public final static String TOKEN_URL = "oauth/v2/token";
    private String clientId;
    private String clientSecret;
    private AuthenticationToken token;

    public OrangeSmsAPI() {

    }

    /**
     * Creates a new {@link OrangeSmsAPI} instance for the given credentials, and make a call to retrieve
     * the authorization token.
     * 
     * @param clientId the client id for using the sms api
     * @param clientSecret the client secret for your application
     */
    public OrangeSmsAPI(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        token = getToken();
    }

    /**
     * This method should return the authorization that basically contain
     * the authorization token to acces the provider Api
     * @see AuthenticationToken
     * @return 
     */
    AuthenticationToken getToken() {
        
        String clientInfos = clientId + ":" + clientSecret;
        String body = "grant_type=client_credentials";
        AuthenticationToken authenticationToken = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(OrangeSmsAPI.BASE_URL + "/" + OrangeSmsAPI.TOKEN_URL);
            postRequest.setHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString(clientInfos.getBytes()));
            StringEntity input = new StringEntity(body);
            input.setContentType("application/x-www-form-urlencoded");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            final ObjectMapper objectMapper = new ObjectMapper();
            authenticationToken = objectMapper.readValue(response.getEntity().getContent(), AuthenticationToken.class);

        } catch (JsonParseException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return authenticationToken;
    }

     /* 
     * (non-Javadoc)
     * @see com.centonni.SmsApi#sendSms(MessageContext message, String receiverAdress)
     */
    @Override
    public boolean sendSms(MessageContext message, String receiverAdress) {
        String receiver="tel:+"+receiverAdress;
        String path = BASE_URL + "/" + "smsmessaging/v1/outbound/" + message.getSenderAdress() + "/requests";

        String body = bodyToJSON(createMessageBody(message, receiver));

        boolean state = false;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(path);
            postRequest.setHeader("Authorization", token.getAuthorization());
            StringEntity input = new StringEntity(body);
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            if (response.getStatusLine().getStatusCode() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            } else {
                state = true;
                final ObjectMapper objectMapper = new ObjectMapper();
                MessageBody messageBody = objectMapper.readValue(response.getEntity().getContent(), MessageBody.class);
               
            }

        } catch (JsonParseException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return state;
    }

     /* 
     * (non-Javadoc)
     * @see com.centonni.SmsApi#sendSms(MessageContext message, String... receiverAdress)
     */
    @Override
    public boolean sendSms(MessageContext message, String... receiverAdress) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private MessageBody createMessageBody(MessageContext message, String receiverAdress) {

        OutboundSMSMessageRequest messageRequest = new OutboundSMSMessageRequest();
        messageRequest.setAddress(receiverAdress);
        messageRequest.setSenderAddress(message.getSenderAdress());
        messageRequest.setSenderName(message.getSenderName());

        OutboundSMSTextMessage textMessage = new OutboundSMSTextMessage();
        textMessage.setMessage(message.getMessage());

        messageRequest.setOutboundSMSTextMessage(textMessage);

        MessageBody body = new MessageBody(messageRequest);

        return body;
    }

    private String bodyToJSON(MessageBody body) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{}";
        try {
            json = mapper.writeValueAsString(body);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(OrangeSmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return json;
    }

    /* 
     * (non-Javadoc)
     * @see com.centonni.SmsApi#getAuthorisationToken()
     */
    @Override
    public String getAuthorisationToken() {
        return token.getAuthorization();
    }

    /* 
     * (non-Javadoc)
     * @see com.centonni.SmsApi#getAuthorisationTokenExpirationDate()
     */
    @Override
    public Date getAuthorisationTokenExpirationDate() {
        return token.getExpireDate();
    }

    @Override
    public boolean sendSms(MessageContext message, String receiverAdress, String authorisationToken) {
        String receiver="tel:+"+receiverAdress;
        String path = BASE_URL + "/" + "smsmessaging/v1/outbound/" + message.getSenderAdress() + "/requests";

        String body = bodyToJSON(createMessageBody(message, receiver));

        boolean state = false;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(path);
            postRequest.setHeader("Authorization", authorisationToken);
            StringEntity input = new StringEntity(body);
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            if (response.getStatusLine().getStatusCode() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            } else {
                state = true;
                final ObjectMapper objectMapper = new ObjectMapper();
                MessageBody messageBody = objectMapper.readValue(response.getEntity().getContent(), MessageBody.class);
               
            }

        } catch (JsonParseException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return state;
    }

    @Override
    public boolean sendSms(MessageContext message, String authorisationToken, String... receiverAdress) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
