/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



/**
 *
 * @author Karim
 */
public class TwilioSms {

    public static final String ACCOUNT_SID = "AC8fc62d0cb544b63cfaa31f5d26e51d04";
    public static final String AUTH_TOKEN = "5dccfaca0e25cf8c6b1e78bbc7f11a67";

    public void sendSms(String body) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message.creator(new PhoneNumber("+21623422387"),
        new PhoneNumber("+16504377051"), 
        body).create();
    }
}
