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
import com.mycompany.myapp.Entity.votes;
import com.mycompany.myapp.Utils.Statics;

/**
 *
 * @author asus
 */
public class VoteService {
    public static VoteService instance = null;
    public boolean resultok;
    private ConnectionRequest req;
    
        VoteService() {
        req = new ConnectionRequest();

    }

    public static VoteService getInstance() {
        if (instance == null) {
            instance = new VoteService();
        }
        return instance;
    }
    
    public boolean vote(votes v) {
        String url = Statics.BASE_URL + "/votephone/"+v.getvaleur()+"/"+v.getidpublication();
        req.setUrl(url);
        req.addArgument("iduser",Integer.toString(v.getiduser().getId()));
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
