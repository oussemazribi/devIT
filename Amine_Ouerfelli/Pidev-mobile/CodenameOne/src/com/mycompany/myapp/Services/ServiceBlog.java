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
import com.codename1.ui.events.ActionListener;

import com.codename1.io.MultipartRequest;
import com.codename1.l10n.ParseException;
import com.mycompany.myapp.Entity.Blog;
import com.mycompany.myapp.Entity.Comment;
import com.mycompany.myapp.Utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author HPENVY
 */
public class ServiceBlog {

   public ArrayList<Comment> Commentaires;     
   public ArrayList<Blog> blogs;
    
    public static ServiceBlog instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceBlog() {
         req = new ConnectionRequest();
    }
    public static ServiceBlog getInstance() {
        if (instance == null) {
            instance = new ServiceBlog();
        }
        return instance;
    }

    public boolean AjoutBlog(Blog b) throws IOException {
            
          
        String url = Statics.BASE_URL + "/Blogs/";//création de l'URL
        MultipartRequest conreq =new MultipartRequest();
        conreq.setUrl(url);// Insertion de l'URL de notre demande de connexion
        conreq.addArgument( "Sujet",b.getSujet());
        conreq.addArgument( "contenu",b.getConteu());
        conreq.addArgument("file", b.getPhoto());
        conreq.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = conreq.getResponseCode() == 200;
                conreq.removeResponseListener(this); 
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(conreq);
        System.out.println("result "+resultOK);
        return resultOK;
    }
    public List<Map<String, Object>> parseTasks(String jsonText){
       try {
            JSONParser j = new JSONParser();
            System.out.println("json: "+jsonText);
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
              
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

           return list;

        } catch (IOException ex) {
        }
         return null;
    }
   
    
     List<Map<String, Object>>  listActivite;
     
     
     
     
    public java.util.List<Map<String, Object>> getAllBlogs(){
        String url = Statics.BASE_URL+"/AfficheMobile";
         ServiceBlog ser = new ServiceBlog();
        req.setUrl(url);
        req.setPost(false);
        
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("response: "+req.getResponseData());               
               listActivite = ser.parseTasks(new String(req.getResponseData()));

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listActivite;
        
        
        
        
        
    }
        public boolean DeleteBlog(Blog b)
    {
         String url = Statics.BASE_URL + "/supprimerBlogM/"+b.getId();
         req.setUrl(url);
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });           
       NetworkManager.getInstance().addToQueueAndWait(req);
       return resultOK; 
    }
}
