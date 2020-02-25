/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Service;

import com.pidev.IService.IServiceUser;
import com.pidev.Entite.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.pidev.Utils.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceUser implements IServiceUser<User> {

    private Connection con;
    private Statement ste;
    private PreparedStatement ste1;

    public ServiceUser() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(User t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `user`(`idUser`, `Nom` , `Prenom`, `Email` ,`Login`,`MotDePasse`,`Sexe`,`DateNaissance`,`NumTelephone`,`TypeCompte`,`TypeTalent`,`ImgUser`)  "
                + "VALUES (NULL, '" + t.getNom() + "', '" + t.getPrenom() + "', '" + t.getEmail() + "','" + t.getLogin() + "','" + t.getMotDePasse() + "','" + t.getSexe() + "','" + t.getDateNaissance() + "','" + t.getNumTelephone() + "','"
                + t.getTypeCompte() + "','" + t.getTypeTalent() + "','" + t.getImguser() + "');";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete(User u) throws SQLException {

        PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottallent`.`user` where Login =?");
        pre.setString(1, u.getLogin());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
        return true;
    }

    @Override
    public boolean update(String Nom, String Prenom, String Email, String Login, String MotDePasse, String Sexe, String DateNaissance, int NumTelephone, String TypeCompte, String TypeTalent, String ImgUser, int idUser) throws SQLException {
        String sql = "UPDATE user SET Nom=?, Prenom=?, Email=? ,Login=?,MotDePasse=? ,Sexe=?,DateNaissance=?,NumTelephone=?,TypeCompte=?,TypeTalent=?,ImgUser=?  WHERE idUser='" + idUser + "'";

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
            String Prenom = rs.getString(3);
            String Email = rs.getString(4);
            String Login = rs.getString(5);
            String MotDePasse = rs.getString(6);
            String Sexe = rs.getString(7);
            String DateNaissance = rs.getString(8);
            int NumTelephone = rs.getInt(9);
            String TypeCompte = rs.getString(10);
            String TypeTalent = rs.getString(11);
            String Img = rs.getString(12);
            User u = new User(idUser, Nom, Prenom, Email, Login, MotDePasse, Sexe, DateNaissance, NumTelephone, TypeCompte, TypeTalent, Img);
            arr.add(u);
        }
        return arr;

    }

    public void authentication(String Login, String MotDePasse) {

        User u = new User();
        try {
            String sql = "SELECT * from user WHERE Login ='" + Login + "' AND MotDePasse='" + MotDePasse + "'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next() == true) {

//                u.setIdUser(rs.getInt(1));
//                u.setNom(rs.getString(2));
//                u.setPrenom(rs.getString(3));
//                u.setLogin(rs.getString(5));
//                u.setMotDePasse(rs.getString("MotDePasse"));
                System.out.println("user  authentifié");
            } else {
                System.out.println("non trouvé");
            }

        } catch (SQLException ex) {
            Logger.getLogger(IServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public User Recherche_parID(int idUser) {
        User u = new User();
        String req = "select * from user where idUser = ?";

        try {
            ste1 = con.prepareStatement(req);
            ste1.setInt(1, idUser);
            ResultSet rs = ste1.executeQuery();
            if (rs.next()) {
                u = new User(rs.getString("Login"), rs.getString("Nom"));
                System.out.println(u);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }

    public User findById(int idUser) throws SQLException {
        String req = "select * from user where idUser = ?";
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, idUser);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {

                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12));
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public User findByTypeCompte(String TypeCompte) throws SQLException {
        String req = "select * from user where idUser = ?";
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(10, TypeCompte);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {

                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12));
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
