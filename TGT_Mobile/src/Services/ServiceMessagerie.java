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
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import Entities.Conversation;
import Entities.Message;
import Utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author HP
 */
public class ServiceMessagerie {
      public ArrayList<Conversation> tasks;
      public ArrayList<Message> message;
    public static ServiceMessagerie instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
     private ConnectionRequest cr;
    public ServiceMessagerie() {
         req = new ConnectionRequest();
    }
    public static ServiceMessagerie getInstance() {
        if (instance == null) {
            instance = new ServiceMessagerie();
        }
        return instance;
    }
  /*  public boolean addConversation(Message c) {
        String url = "http://127.0.0.1:8001/AjoutMessagesM/" + c.getId_Me()+ "/" + c.getIdU_Friend()+ "/" + c.get();
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
    } */
        public boolean addMessage(Message t,int id,int idme,int idu) {
        String url = Statics.BASE_URL +"/AjoutMessagesM/" + id + "/"+ idme +"/"+ idu + "?&Contenu="  + t.getContenu()  ;
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
    /*     public boolean addProject(Message p ,int id) {
        String url = "http://127.0.0.1:8001/AjoutMessagesM?name=" + p.getName() + "&description=" + p.getDescription() + "&duedate=" + p.getDuedate() + "&team_id=" + p.getTeam_id() + "&etat=1";
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(url);
        con.setPost(true);
        con.addResponseListener((NetworkEvent evt) -> {
            byte[] data = (byte[]) evt.getMetaData();
            String s = new String(data);
            System.out.println(s);
            if (!s.contains("erreur")) {
                Dialog.show("Confirmation", "success", "Ok", null);
                ArrayList<Message> pr = parseMessages(s);
                p.setId_Message(pr.get(0).getId_Message());
                System.out.println(p.getId_Message());
                resultOK = req.getResponseCode() == 200;
                 resultOK= true;
            } else {
                Dialog.show("Erreur", "date", "Ok", null);
                resultOK=false;
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
       return resultOK;
    }
*/
    public ArrayList<Conversation> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Conversation t = new Conversation();
                float id = Float.parseFloat(obj.get("idConversation").toString());
                t.setIdConversation((int)id);
                t.setNom(obj.get("Nom").toString());
                System.err.println(t.getDateCreation());
                 LinkedHashMap<String,Object> date = (LinkedHashMap<String,Object>) obj.get("DateCreation"); 
                 double d = (double) date.get("timestamp");
                  long x= (long) (d*1000L);
                      t.setDateCreation(new Date(x));
                       LinkedHashMap<String,Object> idf = (LinkedHashMap<String,Object>) obj.get("idUFriend"); 
                 double fr = (double) idf.get("id");
                t.setIdU_Friend((int) fr);
                tasks.add(t);
            }
        } catch (IOException ex) {
        }
        return tasks;
    }
    public ArrayList<Conversation> getAllTasks(int idd){
        String url = Statics.BASE_URL +"/affichConversationsM/" +idd;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tasks = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
 public ArrayList<Message> parseMessages(String jsonText){
        try {
            message=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Message t = new Message();
                float id = Float.parseFloat(obj.get("idMessage").toString());
                 t.setId_Message((int)id);
                t.setContenu(obj.get("Contenu").toString());
                t.setEtat(obj.get("etat").toString());
               /*  LinkedHashMap<String,Object> date = (LinkedHashMap<String,Object>) obj.get("Date_Message"); 
                 double d = (double) date.get("timestamp");
                  long x= (long) (d*1000L);
                      t.setDate_Message(new Date(x));*/
               LinkedHashMap<String,Object> idme = (LinkedHashMap<String,Object>) obj.get("idSender"); 
                 double d = (double) idme.get("id");
                     System.err.println(d);
                t.setId_Sender((int) d);
                   LinkedHashMap<String,Object> idau = (LinkedHashMap<String,Object>) obj.get("idReceiver"); 
                 double e = (double) idau.get("id");
                     System.err.println(e);
                t.setId_Receiver((int) e);
                message.add(t);
            }
        } catch (IOException ex) {
        }
        return message;
    }
    public ArrayList<Message> getAllmessages(int id){
        String url = Statics.BASE_URL +"/affichMessagesM/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                message = parseMessages(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return message;
    }
   public void deleteResponse(int id){
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = Statics.BASE_URL +"/supprimerConversationM/"+id;
        ConnectionRequest con = new ConnectionRequest();
     con.setUrl(url);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "Success", "Ok", null);
                        }
                    }
                });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        public void update(int id) {
        String url = Statics.BASE_URL +"/updateMessages/" + id  ;
        req.setUrl(url);
        req.addRequestHeader("X-Requested-With", "XMLHttpRequest");
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
        public boolean modifierMessage(int id) {
        ConnectionRequest con = new ConnectionRequest();
          String url = Statics.BASE_URL +"/updateMessages/" + id  ;
        con.setUrl(url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            Dialog.show("Succés", "Message seen", "ok", null);
            resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return resultOK;
    }
          public void deletMessage(int id){
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = Statics.BASE_URL +"/supprimerMessages/"+id;
        ConnectionRequest con = new ConnectionRequest();
     con.setUrl(url);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "Success", "Ok", null);
                        }
                    }
                });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
}