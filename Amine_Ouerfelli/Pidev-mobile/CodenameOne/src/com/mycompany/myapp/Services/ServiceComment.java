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
import com.mycompany.myapp.Entity.Comment;
import com.mycompany.myapp.Utils.Statics;


/**
 *
 * @author asus
 */
public class ServiceComment {
    public static ServiceComment instance = null;
    public boolean resultok;
    private ConnectionRequest req;
    
        ServiceComment() {
        req = new ConnectionRequest();

    }

    public static ServiceComment getInstance() {
        if (instance == null) {
            instance = new ServiceComment();
        }
        return instance;
    }
    
    public boolean ajoutercommentaire(Comment c) {
        String url = Statics.BASE_URL + "/addcommentM";
        req.addArgument("contenu",c.getContenu());
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
    public boolean supprimerCommentaire(Comment c)
    {
         String url = Statics.BASE_URL + "/deletecommentM/"+c.getId();
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
        public boolean ediCommentaire(Comment c)
    {
         String url = Statics.BASE_URL + "/editCom/"+c.getId();
         req.addArgument("contenu",c.getContenu());
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
