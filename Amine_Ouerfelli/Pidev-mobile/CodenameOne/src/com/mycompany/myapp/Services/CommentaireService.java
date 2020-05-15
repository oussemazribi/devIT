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
import com.mycompany.myapp.Entity.Commentaire;
import com.mycompany.myapp.Utils.Statics;

/**
 *
 * @author asus
 */
public class CommentaireService {
    public static CommentaireService instance = null;
    public boolean resultok;
    private ConnectionRequest req;
    
        CommentaireService() {
        req = new ConnectionRequest();

    }

    public static CommentaireService getInstance() {
        if (instance == null) {
            instance = new CommentaireService();
        }
        return instance;
    }
    
    public boolean ajoutercommentaire(Commentaire c) {
        String url = Statics.BASE_URL + "/addcommentfromphone";
        req.addArgument("contenu",c.getcontenu());
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
    public boolean supprimerCommentaire(Commentaire c)
    {
         String url = Statics.BASE_URL + "/DeleteCom/"+c.getid();
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
        public boolean ediCommentaire(Commentaire c)
    {
         String url = Statics.BASE_URL + "/editCom/"+c.getid();
         req.addArgument("contenu",c.getcontenu());
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
