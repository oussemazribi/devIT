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
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.Entity.Commentaire;
import com.mycompany.myapp.Entity.Medias;
import com.mycompany.myapp.Entity.Publication;
import com.mycompany.myapp.Entity.User;
import com.mycompany.myapp.Entity.reactions;
import com.mycompany.myapp.Entity.votes;
import com.mycompany.myapp.Utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.Date;
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
    public ArrayList<votes> votess;
    public ArrayList<reactions> reactions=new ArrayList();
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

    public boolean addPost(Publication p, ArrayList<String> arraylist) throws IOException {
        String url = Statics.BASE_URL + "/addpost/";
        MultipartRequest request = new MultipartRequest();
        request.setPost(true);
        request.setUrl(url);
        request.addArgument("contenu", p.getContenu());
        request.addArgument("titre", p.getTitre());
        request.addArgument("number", Integer.toString(arraylist.size()));
        for (int i = 0; i < arraylist.size(); i++) {
            request.addData("file" + i, arraylist.get(i), "Image/png");
        }
        request.addArgument("iduser",Integer.toString(p.getIdUser().getId()));
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
            Commentaires = new ArrayList<>();
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
                String sDate1=obj.get("date").toString();  
                SimpleDateFormat postdate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date cool=postdate.parse(sDate1);
                System.out.println(cool);
                p.setDate(sDate1);
               
                p.setnbcomments((int) Float.parseFloat(obj.get("nbcomments").toString()));
                //p.setnbreacts((int) Float.parseFloat(obj.get("ReactionPost").toString()));
                p.setnbvotes((int) Float.parseFloat(obj.get("votesPost").toString()));
                p.setType(obj.get("type").toString());
                Posts.add(p);

            }
            List<Map<String, Object>> comments= (List<Map<String, Object>>) PostListJson.get("Comments");
            for (Map<String, Object> obj : comments) {
                Commentaire c = new Commentaire();
                float id = Float.parseFloat(obj.get("id").toString());
                User u = User.createUser((Map<String, Object>) obj.get("idUser"));
                Publication po = Publication.createPost((Map<String, Object>) obj.get("post"));
                c.setpost(po);
                c.setuser(u);
                c.setid((int) id);
                c.setcontenu(obj.get("contenue").toString());

                Commentaires.add(c);

            }
            List<Map<String, Object>> Votes = (List<Map<String, Object>>) PostListJson.get("votes");
            for (Map<String, Object> obj : Votes) {
                votes c = new votes();
                float id = Float.parseFloat(obj.get("id").toString());
                User u = User.createUser((Map<String, Object>) obj.get("idUser"));
                Publication po = Publication.createPost((Map<String, Object>) obj.get("post"));
                c.setidpublication(po.getId());
                c.setiduser(u);
               
                float valeur=Float.parseFloat(obj.get("valeur").toString());
                c.setvaleur((int)valeur);

                votess.add(c);

            }
            List<Map<String, Object>> reacts = (List<Map<String, Object>>) PostListJson.get("reacts");
            for (Map<String, Object> obj : reacts) {
                reactions r = new reactions();
                float id = Float.parseFloat(obj.get("id").toString());
                User u = User.createUser((Map<String, Object>) obj.get("idUser"));
                Publication po = Publication.createPost((Map<String, Object>) obj.get("post"));
                r.setidpublication(po.getId());
                r.setiduser(u);              
                float type=Float.parseFloat(obj.get("type").toString());             
                r.settype((int)type);
                reactions.add(r);

            }

            for (Publication p : Posts) {
             
                for (Medias m : Medias) {
                  
                    if (Objects.equals(m.getPost().getId(), p.getId())) {
                        p.getMediapost().add(m);
                    }
                }

            }

            for (Publication p : Posts) {
               
                for (Commentaire c : Commentaires) {
                    
                    if (c.getpost().getId() == p.getId()) {
                        p.getCommentaires().add(c);
                    }
                }
            }
       for (Publication p : Posts) {
                for (reactions r : reactions) {
                    System.out.println(r);
                    if (r.getidpublication() == p.getId()) {
                        p.getReactions().add(r);
                    }
                }
            }
           for (Publication p : Posts) {
             
                if(votess!=null){
                for (votes v : votess) {
                 
                    if (v.getidpublication() == p.getId()) {
                        p.getVotes().add(v);
                    }
                }
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

    public boolean Deletepost(Publication p) {

        String url = Statics.BASE_URL + "/Deletefrommobile/" + p.getId();
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
    public boolean sharepost(Publication p)
    {
        
        String url = Statics.BASE_URL + "/partager/"+p.getContenu()+"/"+p.getIdUser().getId();
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
