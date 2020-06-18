/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.fos_user;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author loume78
 */
public class ServiceUser {
    
    public static ServiceUser instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public fos_user User = new fos_user();

    public ServiceUser() {
        req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {

        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }
    
    public fos_user parseUserF(String jsonText) {
        fos_user UserL = new fos_user();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> UserListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                float id = Float.parseFloat(UserListJson.get("id").toString());
                UserL.setId((int) (id));
                float nbD = Float.parseFloat(UserListJson.get("nbdiament").toString());
                UserL.setNbdiament((int) (nbD));
                UserL.setEmail(UserListJson.get("email").toString());
                UserL.setUsername(UserListJson.get("username").toString());
                UserL.setImguser(UserListJson.get("imguser").toString());
                UserL.setTypecompte(UserListJson.get("typecompte").toString());
                System.out.println(UserL);
        } catch (IOException ex) {
                ex.getMessage();
        }
        return UserL;
    }
    

    public fos_user parseUser(String jsonText) {
   
        fos_user UserL = new fos_user();
        try {
            JSONParser j = new JSONParser();

            Map<String, Object> UserListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            if (UserListJson.get("type").equals("Login succeed")) {

                float id = Float.parseFloat(UserListJson.get("id").toString());
                UserL.setId((int) (id));
                float nbD = Float.parseFloat(UserListJson.get("nbdiament").toString());
                UserL.setNbdiament((int) (nbD));
                
                
                UserL.setEmail(UserListJson.get("email").toString());
                UserL.setUsername(UserListJson.get("username").toString());
                UserL.setImguser(UserListJson.get("imguser").toString());
                UserL.setTypecompte(UserListJson.get("typecompte").toString());
                
                
                
                

            } else {
                return null;
            }

        } catch (IOException ex) {
                ex.getMessage();
        }

        return UserL;
    }

    public fos_user Login(String username,String password) {
        String url =Statics.BASE_URL+"/loginMobile/"+username+"/"+password;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                User = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return User;
    }

    public fos_user FindUser(int id) {
        String url =Statics.BASE_URL+"/FindUserId/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                User = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return User;
    }
    
    
     
     
     public void DecrementDiamant(int id,int id1) {
        ConnectionRequest con = new ConnectionRequest();
        String url =Statics.BASE_URL+"/api/mobile/"+id+"/"+id1;
        
        con.setUrl(url);
        con.addResponseListener((ee) -> {
            String str = new String(con.getResponseData());
            //System.out.println(str);
            
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
     
     public boolean addUser(fos_user u) {
        String url = Statics.BASE_URL+"/newnew?&password=" + u.getPassword() + "&username=" + u.getUsername() + "&email=" + u.getEmail() + "&typecompte=" + u.getTypecompte() + "&imguser=" + u.getImguser() ;
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
     
     public fos_user getuser(int id){
      String Url=Statics.BASE_URL +"/finduser/"+ id;
          req.setUrl(Url);
            req.setPost(false);
            req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                User = parseUserF(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return User;
    }
    
    
}
