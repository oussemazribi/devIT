/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.Entity.reactions;
import com.mycompany.myapp.Utils.Statics;

/**
 *
 * @author asus
 */
public class ReactService {
    public static ReactService instance = null;
    public boolean resultok;
    private ConnectionRequest req;
    
        ReactService() {
        req = new ConnectionRequest();

    }

    public static ReactService getInstance() {
        if (instance == null) {
            instance = new ReactService();
        }
        return instance;
    }
    
    public boolean reagir(reactions r) {
        String url = Statics.BASE_URL + "/react/"+r.gettype()+"/"+r.getidpublication();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultok = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultok;
    }
    
}
