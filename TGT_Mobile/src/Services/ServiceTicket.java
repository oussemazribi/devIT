/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Participation;
import Entities.Ticket;
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
public class ServiceTicket {
    
     public ArrayList<Ticket> Tickets;
    
    public static ServiceTicket instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceTicket() {
        req = new ConnectionRequest();
    }

    public static ServiceTicket getInstance() {
        if (instance == null) {
            instance = new ServiceTicket();
        }
        
    return instance;
    
}
    
    
    public ArrayList<Ticket> parseTasks(String jsonText) {
        try {
            Tickets = new ArrayList<>();

            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Ticket t = new Ticket();
                
                float id = Float.parseFloat(obj.get("idticket").toString());
                t.setIdTicket((int) id);
                
                
                t.setMotDePasse(obj.get("motdepasse").toString());
                t.setPhoto(obj.get("photo").toString());
                
                Map<String, Object> time = (Map<String, Object>)obj.get("dateemission");
                Date dateE = new Date((long)Double.parseDouble(time.get("timestamp").toString())*1000L);
                t.setDateEmission(dateE);
                
                
                Map<String, Object> contentComp = (Map<String, Object>) obj.get("idcompetition");

                ArrayList myList1 = new ArrayList(contentComp.values());
                myList1.get(0);
                
                float idComp = Float.parseFloat(myList1.get(0).toString());
                t.setComp((int) idComp);
                
                Map<String, Object> content = (Map<String, Object>) obj.get("iduser");

                ArrayList myList = new ArrayList(content.values());
                myList.get(6);

                float user = Float.parseFloat(myList.get(6).toString());
                t.setUser((int) user);

                Tickets.add(t);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return Tickets;
    }
    
    public ArrayList<Ticket> getAllTickets() {
        String url = Statics.BASE_URL + "/api/affTmobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(Tickets);
                Tickets = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Tickets;
    }
    
    
    public boolean addTicket(Ticket t) {
       

        String url = Statics.BASE_URL + "/api/ajoutTicketMobile?user=" + t.getUser() + "&competition=" + t.getComp();
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
    
     public void supprimerTicket(int id,int id1) {
        ConnectionRequest con = new ConnectionRequest();
        String Url =Statics.BASE_URL +"/api/suppTmobile/"+id+"/"+id1;
        System.out.println(Url);
        con.setUrl(Url);
        con.addResponseListener((ee) -> {
            String str = new String(con.getResponseData());
            //System.out.println(str);
            Dialog.show("Succés", "Ticket supprimée", "ok", null);
//            new afficherComp(current).show();
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
    
    
    
    
}
