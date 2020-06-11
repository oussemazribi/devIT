/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessioncontrol;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.html.HTMLParser;
import com.codename1.xml.XMLParser;
import com.mycompany.myapp.Entity.User;
import com.mycompany.myapp.Utils.Statics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.mindrot.BCrypt;

/**
 *
 * @author asus
 */
public class Session {

    private String username;
    private String password;
    private static Session session;
    private User user;
    String token;

    private Session() {

    }

    public User getConnectedUser() {
        if (user != null) {
            return user;
        }
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Statics.BASE_URL + "/user");
        List<User> list = new ArrayList<>();
        con.addResponseListener((NetworkEvent evt) -> {
            try {
                JSONParser jsonp = new JSONParser();
                Map<String, Object> mapUser = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                list.add(User.createUser(mapUser));
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        user = list.get(0);
        return list.get(0);
    }

    public static Session getInstance() {
        if (session == null) {
            session = new Session();
        }
        return session;
    }

    public void setParameters(String username, String password) {
        this.username = username;
        this.password = password;
       
    }
    public User getuser()
    {
        return this.user;
    }
    @SuppressWarnings("empty-statement")
    public boolean initSession() throws IOException {
        User u = getUserByUsername(username);
        String hashed = u.getPassword().substring(0, 2) + "a" + u.getPassword().substring(3);
        if (!BCrypt.checkpw(password, hashed)) {
            return false;
        }
        ConnectionRequest con = new ConnectionRequest() {
            protected void readHeaders(Object connection) throws IOException {
                String[] headerNames = getHeaderFieldNames(connection);
                for (String headerName : headerNames) {
                    if(headerName=="X-Debug-token")
                        token = getHeader(null,headerName);
                    
                }
            }
        };
        con.setCookiesEnabled(true);
        con.setUrl(Statics.BASE_URL + "/login");
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(token);
        con = new ConnectionRequest(Statics.BASE_URL + "/login_check", true);
        con.addArgument("_username", username);
        System.out.println(u.getPassword());
        con.addArgument("_password", u.getPassword());
        con.addArgument("_csrf_token", token);
        NetworkManager.getInstance().addToQueueAndWait(con);
        if (con.getUrl().equals(Statics.BASE_URL + "/affichiercompetition")) {
            return true;
        }
        return false;
    }

    private User getUserByUsername(String username) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Statics.BASE_URL + "/user");
        con.addArgument("username", username);
        List<User> list = new ArrayList<>();
        con.addResponseListener((NetworkEvent evt) -> {
            try {
                JSONParser jsonp = new JSONParser();
                List<Map<String, Object>> mapList = (List<Map<String, Object>>) jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray())).get("root");
                Map<String, Object> mapUser = mapList.get(0);
                list.add(User.createUser(mapUser));
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        user = list.get(0);
        return list.get(0);
    }

    public User getFullConnectedUser() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Statics.BASE_URL + "/Rana_Web/web/app_dev.php/interaction/user");
        User user = new User();
        con.addResponseListener((NetworkEvent evt) -> {
            try {
                JSONParser jsonp = new JSONParser();
                Map<String, Object> mapUser = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                user.setId((int) Float.parseFloat(mapUser.get("id").toString()));
                user.setUsername(mapUser.get("username").toString());
                user.setNumtel(mapUser.get("numtel").toString());
                user.setEmail(mapUser.get("email").toString());
                float id = Float.parseFloat(mapUser.get("id").toString());
                user.setId((int) id);
                float nbd = Float.parseFloat(mapUser.get("nbdiament").toString());
                user.setNbdiament((int) nbd);
                user.setTypecompte(mapUser.get("typecompte").toString());
                user.setTypetalent(mapUser.get("typetalent").toString());
                user.setImguser(mapUser.get("imguser").toString());
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return user;
    }

}
