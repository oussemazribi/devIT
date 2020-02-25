/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;


import com.esprit.IService.IServiceUser;
import com.esprit.Entite.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.esprit.Utils.DataBase;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.scene.image.Image;


public class ServiceUser implements IServiceUser<User> {

    private Connection con;
    private Statement ste;

    public ServiceUser() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(User t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `user`(`idUser`, `Nom` , `Prenom`, `Email` ,`Login`,`MotDePasse`,`Sexe`,`DateNaissance`,`NumTelephone`,`TypeCompte`,`TypeTalent`,`ImgUser`,`NbDiament`)  "
                + "VALUES (NULL, '" + t.getNom() + "', '" + t.getPrenom() + "', '" + t.getEmail() + "','" + t.getLogin() + "','" + t.getMotDePasse() + "','" + t.getSexe() + "','" + t.getDateNaissance() + "','" + t.getNumTelephone() + "','"
                + t.getTypeCompte() + "','" + t.getTypeTalent() + "','" + t.getImguser() + "','" + t.getNbDiament()+ "');";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete(User u) throws SQLException {
        
       
         
        PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottalent`.`user` where Login =?");
        pre.setString(1, u.getLogin());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
           
             
           
        }
        return true;
    }

    @Override
    public boolean update(String Nom, String Prenom, String Email, String Login, String MotDePasse, String Sexe, String DateNaissance, int NumTelephone, String TypeCompte, String TypeTalent, String ImgUser,int NbDiament, int idUser) throws SQLException {
        String sql = "UPDATE user SET Nom=?, Prenom=?, Email=? ,Login=?,MotDePasse=? ,Sexe=?,DateNaissance=?,NumTelephone=?,TypeCompte=?,TypeTalent=?,ImgUser=?,NbDiament=?  WHERE idUser='" + idUser + "'";
        
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, Nom);
        statement.setString(2, Prenom);
        statement.setString(3, Email);
        statement.setString(4, Login);
        statement.setString(5, MotDePasse);
        statement.setString(6, Sexe);
        statement.setString(7, DateNaissance);
        statement.setInt(8, NumTelephone);
        statement.setString(9, TypeCompte);
        statement.setString(10, TypeTalent);
        statement.setString(11, ImgUser);
        statement.setInt(12, NbDiament);
        
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            
            
            System.out.println("An existing user was updated successfully!");
        }
        return true;
    }

    @Override
    public List<User> readAll() throws SQLException {
        List<User> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from user");
        while (rs.next()) {
            int idUser = rs.getInt(1);
            String Nom = rs.getString(2);
            String Prenom = rs.getString("Prenom");
            String Email = rs.getString("Email");
            String Login = rs.getString("Login");
            String MotDePasse = rs.getString("MotDePasse");
            String Sexe = rs.getString("Sexe");
            String DateNaissance = rs.getString("DateNaissance");
            int NumTelephone = rs.getInt("NumTelephone");
            String TypeCompte = rs.getString("TypeCompte");
            String TypeTalent = rs.getString("TypeTalent");
            String Imguser = rs.getString("Imguser");
            int NbDiament = rs.getInt("NbDiament");

            User u = new User(idUser, Nom, Prenom, Email, Login, MotDePasse, Sexe, DateNaissance, NumTelephone, TypeCompte, TypeTalent, Imguser,NbDiament);
            arr.add(u);
        }
        return arr;
    }
    
      
      
      
        public String findByIdname(int idUser) throws SQLException {
            String req = "select Nom from user where idUser = ?";
            String var="";
            try {
                PreparedStatement ps = con.prepareStatement(req);
                ps.setInt(1, idUser);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    
                  var= resultSet.getString(1);
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return var;
        }
        
             
                 
 
}
