/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.Entity.Commentaire;
import com.mycompany.myapp.Entity.Medias;
import com.mycompany.myapp.Entity.Publication;
import com.mycompany.myapp.Entity.User;
import com.mycompany.myapp.Utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author asus
 */
public class PostService {

    public ArrayList<Publication> Posts;
    public ArrayList<Medias> Medias;
    public ArrayList<Commentaire> Commentaires;
    public ArrayList popo;
    public static PostService instance = null;
    public boolean resultok;
    private ConnectionRequest req;

    PostService() {
        req = new ConnectionRequest();

    }

    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        return instance;
    }

    public boolean addPost(Publication p,ArrayList<String> arraylist) throws IOException {
        String url = Statics.BASE_URL + "/addpost/";     
        MultipartRequest request=new MultipartRequest();  
        request.setPost(true);
        request.setUrl(url);
        request.addArgument("contenu",p.getContenu());
        request.addArgument("titre",p.getTitre());
        request.addArgument("number",Integer.toString(arraylist.size()));
        for(int i=0;i<arraylist.size();i++){
        request.addData("file"+i,arraylist.get(i),"Image/png");
        }
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultok = request.getResponseCode() == 200; //Code HTTP 200 OK
                System.out.println(resultok);
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
        return resultok;
    }

    public ArrayList<Publication> parsePosts(String jsonText) throws ParseException {
        try {
            Posts = new ArrayList<>();
            Medias = new ArrayList<>();
            Commentaires=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> PostListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> Mediaslist = (List<Map<String, Object>>) PostListJson.get("Posts");
            for (Map<String, Object> obj : Mediaslist) {
                Medias m = new Medias();
                float id = Float.parseFloat(obj.get("id").toString());
                m.setId((int) id);
                User u = User.createUser((Map<String, Object>) obj.get("idUser"));
                m.setUser(u);
                Publication p = Publication.createPost((Map<String, Object>) obj.get("idpost"));
                m.setSource(obj.get("source").toString());
                m.setMediatype(obj.get("mediatype").toString());               
                m.setPost(p);
                Medias.add(m);

            }
            List<Map<String, Object>> posts = (List<Map<String, Object>>) PostListJson.get("Medias");
            for (Map<String, Object> obj : posts) {
                Publication p = new Publication();
                float id = Float.parseFloat(obj.get("id").toString());
               
                User u = User.createUser((Map<String, Object>) obj.get("idauthor"));
                p.setIdUser(u); 
                p.setId((int) id);
                p.settitre(obj.get("titre").toString());
                p.setContenu(obj.get("contenue").toString());
          
                // p.setMediapost((ArrayList<String>) obj.get("medias"));
                /*String sDate1=obj.get("date").toString();  
                /*Date postdate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(sDate1); */
                 /*p.setDatePublication(postdate);*/
                p.setnbcomments((int) Float.parseFloat(obj.get("nbcomments").toString()));
                //p.setnbreacts((int) Float.parseFloat(obj.get("ReactionPost").toString()));
                p.setnbvotes((int) Float.parseFloat(obj.get("votesPost").toString()));
                Posts.add(p);

            }
            List<Map<String, Object>> Comments= (List<Map<String, Object>>) PostListJson.get("Comments");
                for (Map<String, Object> obj : Comments) {
                Commentaire c=new Commentaire();
                float id = Float.parseFloat(obj.get("id").toString());
                User u = User.createUser((Map<String, Object>) obj.get("idUser"));
                Publication po = Publication.createPost((Map<String, Object>) obj.get("post"));
                c.setpost(po);
                c.setuser(u);
                c.setid((int)id);
                c.setcontenu(obj.get("contenue").toString());
                
                 Commentaires.add(c);
                
            }
            
            
            for( Publication p :Posts)
            {   System.out.println(p);
                for(Medias m : Medias)
                {    System.out.println(m);
                    if(Objects.equals(m.getPost().getId(), p.getId()))
                    {
                        p.getMediapost().add(m);
                    }
                }

            }
            
            for(Publication p :Posts)
            {   System.out.println("popo");
                for(Commentaire c :Commentaires)
                {    System.out.println(c);
                    if(c.getpost().getId()==p.getId())
                        p.getCommentaires().add(c);
                }
            }
       
    

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        return Posts;

    }

    public ArrayList<Publication> getAllPosts() {
        String url = Statics.BASE_URL + "/showMediaformobile/";
        req.setUrl(url);
        req.setPost(false);
        System.out.println(popo);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    Posts = parsePosts(new String(req.getResponseData()));

                } catch (ParseException ex) {
                    System.out.println("notfound");
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Posts;

    }
    public boolean Deletepost(Publication p)
    {
       
        
         String url = Statics.BASE_URL + "/Deletefrommobile/"+p.getId();
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
