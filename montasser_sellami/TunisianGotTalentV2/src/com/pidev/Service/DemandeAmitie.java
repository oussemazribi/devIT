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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DemandeAmitie {

    private Connection con;
    private PreparedStatement ps;
    Amitie a = new Amitie();

    public DemandeAmitie() {
        con = DataBase.getInstance().getConnection();
    }
    User u = new User();
    ServiceUser ser = new ServiceUser();
    //DemandeAmitie dm = new DemandeAmitie();

    public void ajouterD(Amitie a) throws SQLException {
        String req = "insert into amitie (idUser1,idUser2,Etat,SenderId,BlockId) values (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(req);
            ps.setInt(1, a.getIdUser1());
            ps.setInt(2, a.getIdUser2());
            ps.setString(3, a.getEtat());
            ps.setInt(4, a.getSenderId());
            ps.setInt(5, a.getBlockId());

            // 
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(Integer r) {
        String req = "delete from amitie where SenderId =?";
        try {
            ps = con.prepareStatement(req);
            ps.setInt(4, r);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    /**
     *
     * @return
     */
    public ObservableList<User> getAll(int idUser) {
        ObservableList<User> retour = FXCollections.observableArrayList();
        try {
            PreparedStatement pt = con.prepareStatement("SELECT * from user u where u.idUser in (select idUser2 from amitie a where a.idUser1=" + idUser + " and a.etat=1 )");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                retour.add(new User(nom, prenom));
            }
        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
        }
        return retour;    
        
    }

    
    
    
    
    public void acceptDemande(Amitie a) {

        try {
            String req1 = "UPDATE  amitie SET etat=" + 1 + "";

            ps = con.prepareStatement(req1);

              //ps.setString(1,"1");
            //ps.setString(3,"accepte");
            // ps.setInt(1,a.getIdUser1());
            //  ps.setInt(,a.getIdUser2());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
