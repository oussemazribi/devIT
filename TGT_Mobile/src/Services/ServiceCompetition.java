/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Competition;
import Entities.fos_user;
import GUI.afficherComp;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.List;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import java.util.Map;

/**
 *
 * @author loume78
 */
public class ServiceCompetition {

    public ArrayList<Competition> competitions;
    Form current;

    public static ServiceCompetition instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceCompetition() {
        req = new ConnectionRequest();
    }

    public static ServiceCompetition getInstance() {
        if (instance == null) {
            instance = new ServiceCompetition();
        }
        return instance;
    }

    public ArrayList<Competition> parseTasks(String jsonText) {
        try {
            competitions = new ArrayList<>();

            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Competition t = new Competition();
                float id = Float.parseFloat(obj.get("idcompetition").toString());
                t.setIdCompetition((int) id);
                float cout = Float.parseFloat(obj.get("cout").toString());
                t.setCout((int) cout);
                Map<String, Object> content = (Map<String, Object>) obj.get("iduser");

                ArrayList myList = new ArrayList(content.values());
                myList.get(0);
                
                float user = Float.parseFloat(myList.get(6).toString());
                t.setIdUser((int) user);

                Map<String, Object> time = (Map<String, Object>) obj.get("datedebut");
                Date dateD = new Date((long) Double.parseDouble(time.get("timestamp").toString()) * 1000L);

                Map<String, Object> time1 = (Map<String, Object>) obj.get("datefin");
                Date dateF = new Date((long) Double.parseDouble(time1.get("timestamp").toString()) * 1000L);

                t.setDateDebut(dateD);
                t.setDateFin(dateF);
                t.setTitre(obj.get("titre").toString());
                t.setImageC(obj.get("imagec").toString());
                t.setDescription(obj.get("description").toString());
                t.setTypeDeTalent(obj.get("typedetalent").toString());

                competitions.add(t);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return competitions;
    }

    public ArrayList<Competition> getAllCompetitions() {
        String url = Statics.BASE_URL + "/api/affichComp";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                competitions = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return competitions;
    }

    public boolean addCompetition(Competition c) {
        String dd = new SimpleDateFormat("yyyy-MM-dd").format(c.getDateDebut());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(c.getDateFin());

        String url = Statics.BASE_URL + "/api/ajout?titre=" + c.getTitre() + "&description=" + c.getDescription() + "&user=" + c.getIdUser() + "&cout=" + c.getCout() + "&datedebut=" + dd + "&datefin=" + df + "&typedetalent=" + c.getTypeDeTalent() + "&image=" + c.getImageC();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
                new afficherComp(current).show();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public void supprimerComp(int id) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = Statics.BASE_URL + "/api/supprimerC/" + id;

        con.setUrl(Url);
        con.addResponseListener((ee) -> {
            String str = new String(con.getResponseData());
            //System.out.println(str);
            Dialog.show("Succés", "Competition supprimée", "ok", null);
            new afficherComp(current).show();
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    public boolean modifierEvent(Competition c, int id) {
        ConnectionRequest con = new ConnectionRequest();
        String dd = new SimpleDateFormat("yyyy-MM-dd").format(c.getDateDebut());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(c.getDateFin());

        String Url = Statics.BASE_URL + "/api/modif/" + id + "?titre=" + c.getTitre()
                + "&description=" + c.getDescription()
                + "&user=" + c.getIdUser()
                + "&cout=" + c.getCout()
                + "&datedebut=" + dd
                + "&datefin=" + df
                + "&typedetalent=" + c.getTypeDeTalent()
                + "&image=" + c.getImageC();
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

            Dialog.show("Succés", "Event modifié", "ok", null);
            resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
            new afficherComp(current).show();

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return resultOK;
    }
    
     public Competition FindCompetition(String titre)
     {
         
         ArrayList<Competition> myPar = getAllCompetitions();
         Competition c = new Competition();
         
         for (Competition li : myPar) {
             if(li.getTitre().equals(titre) )
             {
             c.setCout(li.getCout());
             c.setDateDebut(li.getDateDebut());
             c.setDateFin(li.getDateFin());
             c.setDescription(li.getDescription());
             c.setIdCompetition(li.getIdCompetition());
             c.setIdUser(li.getIdUser());
             c.setImageC(li.getImageC());
             c.setTitre(li.getTitre());
             c.setTypeDeTalent(li.getTypeDeTalent());
             
             }
             
         }
         return c;
         
     }

}
