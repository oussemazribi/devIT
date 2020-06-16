/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Myapp.GUI;

import com.codename1.messaging.Message;
import com.codename1.ui.Display;

/**
 *
 * @author BENTEKFA
 */
public class Newsletter {

    public Newsletter() {
        Message m = new Message("Body of message");
        //m.getAttachments().put(textAttachmentUri, "text/plain");
        //m.getAttachments().put(imageAttachmentUri, "image/png");
        Display.getInstance().sendMessage(new String[]{"someone@gmail.com"}, "Subject of message", m);
    }
}
