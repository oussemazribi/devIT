/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TGT.myapp.services;
import com.TGT.myapp.entities.Blog;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.TGT.myapp.utils.Statics;
import com.codename1.io.MultipartRequest;
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
     public List<Map<String, Object>> parseActiviteTaskJson(String json) {
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));              
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
           return list;
        } catch (IOException ex) {
        }
         return null;
    }    
   public ArrayList<Blog> blogs;
    
    public static ServiceBlog instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceBlog() {
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
        conreq.addData("file", b.getPhoto(), "Image/png");
        conreq.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = conreq.getResponseCode() == 200;
                conreq.removeResponseListener(this); 
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(conreq);
        return resultOK;
    }
    public ArrayList<Blog> parseTasks(String jsonText){
        try {
            blogs =new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
              /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
            */
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Blog b = new Blog();
                float id = Float.parseFloat(obj.get("id").toString());
                b.setId((int)id);
                b.setSujet(obj.get("sujet").toString());
                b.setConteu(obj.get("contenu").toString());
                b.setPhoto(obj.get("photo").toString());
                //Ajouter la tâche extraite de la réponse Json à la liste
                blogs.add(b);
            }       
        } catch (IOException ex) {            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        */
        
        return blogs;
    }
   
    public ArrayList <Blog> getAllBlogs(){
        String url = Statics.BASE_URL+"/Affiche2/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                blogs = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return blogs;
    }   
}
