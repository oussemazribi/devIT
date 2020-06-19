/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.Entity.Medias;
import com.mycompany.myapp.Entity.Publication;
import com.mycompany.myapp.Entity.User;
import com.mycompany.myapp.Utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author asus
 */
public class MediaService {
   public ArrayList<Medias> Medias;
    
    public static MediaService instance=null;
    public boolean resultok;
    private ConnectionRequest req;
    
        private MediaService() {
         req= new ConnectionRequest();
    }
        
    public static MediaService getInstance()
    {
          if (instance == null) {
            instance = new MediaService();
        }
        return instance;
    }
        public ArrayList<Medias> parseMedias(String jsonText) throws ParseException, IOException{
        try {
            Medias=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> PostListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));     
            List<Map<String,Object>> list = (List<Map<String,Object>>)PostListJson.get("root");
            for(Map<String,Object> obj : list){
                
                Medias m = new Medias();
                float id = Float.parseFloat(obj.get("id").toString()); 
                m.setId((int)id);
                User u=User.createUser((Map<String, Object>)obj.get("idUser"));
                Publication p=Publication.createPost((Map<String,Object>)obj.get("idpost"));
                m.setSource(obj.get("source").toString());
                m.setMediatype(obj.get("mediatype").toString());
                m.setUser(u);
               
                

                Medias.add(m);
                
            }
            
            
        } catch (IOException ex) {
            System.out.println("null");
            
        }
        return Medias;
    }
    
    public ArrayList<Medias> getAllmedias(){
        String url = Statics.BASE_URL+"/showMediaformobile/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    try {
                        Medias= parseMedias(new String(req.getResponseData()));
                    } catch (IOException ex) {
                        
                    }
         
                } catch (ParseException ex) {
                    System.out.println("notfound");
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Medias;
       
    }


}
