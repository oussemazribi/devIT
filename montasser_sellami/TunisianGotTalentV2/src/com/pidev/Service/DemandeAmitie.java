/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Service;

import com.pidev.Iservice.IServiceUser;
import com.pidev.Entite.Amitie;
import com.pidev.Entite.User;
import com.pidev.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DemandeAmitie  {
    private Connection con;
     private PreparedStatement ps;
     Amitie a = new Amitie();
        public DemandeAmitie() {
        con = DataBase.getInstance().getConnection();
        }

        public void ajouterD(Amitie a) throws SQLException{
String req = "insert into amitie (idUser1,idUser2,Etat,SenderId,BlockId) values (?,?,?,?,?)";
try {
            ps = con.prepareStatement(req);
            ps.setInt(1,a.getIdUser1());
           ps.setInt(2, a.getIdUser2());
            ps.setString(3, a.getEtat());
            ps.setInt(4, a.getSenderId());
            ps.setInt(5, a.getBlockId());

        ps.setString(3,"1");
          ps.executeUpdate();
          
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        
  public void delete(Integer r) {
 String req = "delete from amitie where SenderId =?";
        try {
            ps = con.prepareStatement(req);
            ps.setInt(4,r);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }    }
 
    public List<Amitie> getAll() {

String req = "select * from amitie";
        List<Amitie> a = new ArrayList<>();
        try {
            ps = con.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Amitie a1 = new Amitie(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
                a.add(a1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   
    return a ;    }
    public void acceptDemande(Amitie a) {
        Amitie a2 = new Amitie();
try {
            String req1 ="UPDATE  amitie SET etat=?   WHERE idUser1 not like SenderId  =?";
            
            ps = con.prepareStatement(req1);
              a2 =new Amitie();
            ps.setString(3,"accepte"); 
            ps.setInt(1,a2.getIdUser1());
            ps.setInt(2,a2.getIdUser2());
            ps.executeUpdate() ; 
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
