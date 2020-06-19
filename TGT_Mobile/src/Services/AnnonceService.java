/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entities.Annonce;
import Entities.Categorie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ousse
 */
public class AnnonceService {
            ArrayList<Categorie> categoireList = new ArrayList<>();
            ArrayList<Annonce> annonces = new ArrayList<>();

    
    public ArrayList<Annonce> parseAnnonce(String json) {


        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            for (Map<String, Object> obj : list) {
                Annonce e = new Annonce();
                float id = Float.parseFloat(obj.get("idAnnonce").toString());
                e.setId((int) id);
                e.setCategorie(((Map<String, Object>) obj.get("categorie")).get("nom").toString());
                e.setEtat( obj.get("etat").toString());
                e.setNom(obj.get("nom").toString());
              e.setUser(((Map<String, Object>) obj.get("user")).get("username").toString());
                              e.setIduser((int)Float.parseFloat(((Map<String, Object>) obj.get("user")).get("id").toString()));
              e.setDescription(obj.get("description").toString());
              e.setImages(obj.get("images").toString());
              e.setPrix( (int) Float.parseFloat(obj.get("prix").toString()));
                              e.setCategirie_id((int)Float.parseFloat(((Map<String, Object>) obj.get("categorie")).get("id").toString()));

              e.setPrix( (int) Float.parseFloat(obj.get("prix").toString()));
              Map<String, Object> dateObj = (Map)obj.get("dateCreation");
                long timestamp = (long)((double) dateObj.get("timestamp"))*1000;
                e.setDate(new Date(timestamp).toString());
              annonces.add(e);
            }
        } catch (IOException ex) {
        }
        return annonces;

    }
     public ArrayList<Categorie> parseCategorie(String json) {


        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            for (Map<String, Object> obj : list) {
                Categorie e = new Categorie();
                float id = Float.parseFloat(obj.get("id").toString());
                e.setId((int) id);
                e.setNom(obj.get("nom").toString());
              categoireList.add(e);
            }
        } catch (IOException ex) {
        }
        return categoireList;

    }
    
        public ArrayList<Categorie> getCaegories() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Intégration_Web/web/app_dev.php/api/categorie");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                AnnonceService ser = new AnnonceService();
                categoireList = ser.parseCategorie(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return categoireList;
    }
         public ArrayList<Annonce> getAnnonces() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Intégration_Web/web/app_dev.php/api/annonce/");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                AnnonceService ser = new AnnonceService();
                annonces = ser.parseAnnonce(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return annonces;
    }
        public ArrayList<Annonce> getAnnonceByCat(int idCat) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Intégration_Web/web/app_dev.php/api/annonce_cats/"+idCat);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                AnnonceService ser = new AnnonceService();
                annonces = ser.parseAnnonce(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return annonces;
    }
  public void addAnnonce(int iduser , int  idcat , String nom , String description , int prix , String images) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        
        String Url = "http://localhost/Intégration_Web/web/app_dev.php/api/add/" +  iduser + "/" + idcat + "/" + nom + "/" + description + "/" + prix +"/"+ images+"/"  ;// création de l'URL
      System.out.println(Url);
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
   public void updateAnoonce(int id , int  idcat , String nom , String description , int prix ,String images) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/Intégration_Web/web/app_dev.php/api/update/" +  id + "/" + idcat + "/" + nom + "/" + description + "/" + prix +"/"+images  ;// création de l'URL
        System.out.println(Url);
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

       
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
public void deleteAnnonce(int id) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/Intégration_Web/web/app_dev.php/api/delete/" +  id   ;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

}
