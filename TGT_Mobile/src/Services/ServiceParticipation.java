/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Competition;
import Entities.Participation;
import GUI.afficherComp;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author loume78
 */
public class ServiceParticipation {
    
    public ArrayList<Participation> participations;
    boolean find=false;
    
    public static ServiceParticipation instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceParticipation() {
        req = new ConnectionRequest();
    }

    public static ServiceParticipation getInstance() {
        if (instance == null) {
            instance = new ServiceParticipation();
        }
        return instance;
    }
    
    
    
   
    
    
    public ArrayList<Participation> parseTasks(String jsonText) {
        try {
            participations = new ArrayList<>();

            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            

            java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Participation t = new Participation();
                
                float id = Float.parseFloat(obj.get("idparticipation").toString());
                t.setIdparticipation((int) id);
                
                
                Map<String, Object> contentComp = (Map<String, Object>) obj.get("idcompetition");

                ArrayList myList1 = new ArrayList(contentComp.values());
                myList1.get(0);
                
                float idComp = Float.parseFloat(myList1.get(0).toString());
                t.setCompet((int) idComp);
                
                Map<String, Object> content = (Map<String, Object>) obj.get("iduser");

                ArrayList myList = new ArrayList(content.values());
                myList.get(6);

                float user = Float.parseFloat(myList.get(6).toString());
                t.setUser((int) user);
                
                
                
               

                participations.add(t);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return participations;
    }
    
     public ArrayList<Participation> getAllParticipations() {
        String url = Statics.BASE_URL + "/api/affPmobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                participations = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return participations;
    }
     
     public boolean FindParticipation(int id,int id1)
     {
         
         ArrayList<Participation> myPar = getAllParticipations();
         
         for (Participation li : myPar) {
             if(li.getUser()==id && li.getCompet()==id1)
                 return true;
         }
         return false;
         
     }
     
     
     
     public boolean addParticipation(Participation p) {
       

        String url = Statics.BASE_URL + "/api/ajoutParticipation?user=" + p.getUser() + "&competition=" + p.getCompet();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
//                new afficherComp(current).show();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
     
     public void supprimerParticipation(int id,int id1) {
        ConnectionRequest con = new ConnectionRequest();
        String Url =Statics.BASE_URL +"/api/suppPmobile/"+id+"/"+id1;
        
        con.setUrl(Url);
        con.addResponseListener((ee) -> {
            String str = new String(con.getResponseData());
            //System.out.println(str);
            Dialog.show("Succés", "Participation supprimée", "ok", null);
//            new afficherComp(current).show();
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
    
}
