/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class Basedonnees {

     String url = "jdbc:mysql://localhost:3306/tunisiangottalent?useSSL=false&serverTimezone=UTC";
     String login = "root";
     String pwd = "";
    public  static Basedonnees db;
    public Connection con;
    private Basedonnees() {
         try {
             con=DriverManager.getConnection(url, login, pwd);
             System.out.println("connexion etablie");
         } catch (SQLException ex) {
             System.out.println(ex);
         }
    }
    
    public Connection  getConnection()
    {
    return con;
    }     
    public static Basedonnees getInstance()
    {if(db==null)
        db=new Basedonnees();
    return db;
    }     
     
     
     
     
}
    

