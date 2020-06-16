package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionListener;
import com.pidev.Myapp.Entities.Reclamation;
import com.pidev.Myapp.Utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BENTEKFA
 */
public class ServiceReclamation {

    public ArrayList<Reclamation> reclamations;

    public static ServiceReclamation instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceReclamation() {
        req = new ConnectionRequest();
    }

    public static ServiceReclamation getInstance() {
        if (instance == null) {
            instance = new ServiceReclamation();
        }
        return instance;
    }

    public boolean addReclamation(Reclamation r) throws IOException {
        String url = Statics.BASE_URL + "/reclamation/new/";
        MultipartRequest request = new MultipartRequest();
        request.setPost(true);
        request.setUrl(url);
        request.addArgument("objet", r.getObjet());
        request.addArgument("description", r.getDescription());
        request.addData("file", r.getPhoto(), "Image/png");
        request.addArgument("etat", r.getEtat());

        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = request.getResponseCode() == 200; //Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
        return resultOK;
    }

    public ArrayList<Reclamation> parseReclamations(String jsonText) throws ParseException {
        try {
            reclamations = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> reclamationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) reclamationsListJson.get("root");
            for (Map<String, Object> obj : list) {
                Reclamation r = new Reclamation();

                float id = Float.parseFloat(obj.get("id").toString());
                r.setId((int) id);
                r.setObjet(obj.get("objet").toString());
                r.setDescription(obj.get("description").toString());
                r.setPhoto(obj.get("photo").toString());
                r.setEtat(obj.get("statut").toString());
                // String DateR = obj.get("date").toString();
                // Date f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(DateR); 

                //r.setDateReclamation(f);
                reclamations.add(r);
            }

        } catch (IOException ex) {

        }
        return reclamations;
    }

    public ArrayList<Reclamation> getAllReclamations() {
        String url = Statics.BASE_URL + "/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    reclamations = parseReclamations(new String(req.getResponseData()));
                } catch (ParseException ex) {

                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamations;
    }

    public boolean traiterreclamation(Reclamation r) {
        String url = Statics.BASE_URL + "/rec/"+r.getId();
        req.setUrl(url);
        req.setPost(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                  resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                 req.removeResponseListener(this);
            }       });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }  
            
    public boolean Deleterec(Reclamation r) {
        String url = Statics.BASE_URL + "/supp/" + r.getId();
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
