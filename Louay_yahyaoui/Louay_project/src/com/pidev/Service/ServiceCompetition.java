/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Service;

import com.pidev.Entite.Competition;
import com.pidev.Entite.Ticket;
import com.pidev.Entite.User;
import com.pidev.IService.IServiceCompetition;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.pidev.Test.DataBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class ServiceCompetition implements IServiceCompetition<Competition> {

    private Connection con;
    private Statement ste;

    public ServiceCompetition() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Competition t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`competition` (`idCompetition` , `idUser`, `titre`, `Description` , `TypeDeTalent` , `DateDebut` , `DateFin` , `Cout`, `imageC`) VALUES (NULL, '" + t.getUser().getIdUser() + "', '" + t.getTitre() + "', '" + t.getDescription() + "' , '" + t.getTypeDeTalent() + "' , '" + t.getDateDebut() + "', '" + t.getDateFin() + "', '" + t.getCout() + "', '" + t.getImageC() + "');";
        ste.executeUpdate(requeteInsert);
    }

    @Override
   public boolean delete(Competition t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottalent`.`competition` where Titre =? AND Description =?");
        pre.setString(1, t.getTitre());
        pre.setString(2, t.getDescription());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A Competition was deleted successfully!");
        }
        return true;
    }

    @Override
    public boolean update(String Titre, String Description, String TypeDeTalent, String DateDebut, String DateFin, int Cout,String imageC, String titre) throws SQLException {
//        String sql = "UPDATE competition SET Titre=?, Description=?, DateDebut=?, DateFin=?, Cout=? WHERE Titre=?";
//
//        PreparedStatement statement = con.prepareStatement(sql);
//        statement.setString(1, Titre);
//        statement.setString(2, Description);
//        
//        
//        statement.setString(3, DateDebut);
//        statement.setString(4, DateFin);
//        statement.setInt(5, Cout);
//        statement.setString(6, c.getTitre());
//
//        int rowsUpdated = statement.executeUpdate();
//        if (rowsUpdated > 0) {
//            System.out.println("An existing Competition was updated successfully!");
//        }
//        return true;
        String sql = "UPDATE competition SET Titre=?, Description=?, TypeDeTalent=?, DateDebut=?, DateFin=?, Cout=?,imageC=? WHERE Titre=?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, Titre);
        statement.setString(2, Description);
        statement.setString(3, TypeDeTalent);
        statement.setString(4, DateDebut);
        statement.setString(5, DateFin);
        statement.setInt(6, Cout);
        statement.setString(7, imageC);
        statement.setString(8, titre);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing Competition was updated successfully!");
        }
        return true;
    }

//    @Override
//    public Map<User,Competition> readAll() throws SQLException {
//        List<Competition> arr = new ArrayList<>();
//        List<User> arr2 = new ArrayList<>();
//        Map<User,Competition> map = new HashMap<>();
//        
//        ste = con.createStatement();
//        ResultSet rs = ste.executeQuery("SELECT * \n"
//                + "FROM competition INNER JOIN user \n"
//                + "ON competition.idUser = user.idUser;");
//        while (rs.next()) {
//            int idCompetition = rs.getInt("idCompetition");
//            int idUser1 = rs.getInt("idUser");
//
//            String Titre = rs.getString("Titre");
//            String Description = rs.getString("Description");
//            String TypeDeTalent = rs.getString("TypeDeTalent");
//            String DateDebut = rs.getString("DateDebut");
//            String DateFin = rs.getString("DateFin");
//            int Cout = rs.getInt("Cout");
//            
//            int idUser = rs.getInt("idUser");
//            String Nom = rs.getString("Nom");
//            String Prenom = rs.getString("Prenom");
//            String Email = rs.getString("Email");
//            String Login = rs.getString("Login");
//            String MotDePasse = rs.getString("MotDePasse");
//            String Sexe = rs.getString("Sexe");
//            String DateNaissance = rs.getString("DateNaissance");
//            int NumTelephone = rs.getInt("NumTelephone");
//            String TypeCompte = rs.getString("TypeCompte");
//            String TypeTalent = rs.getString("TypeTalent");
//            String Imguser = rs.getString("Imguser");
//            ServiceUser service = new ServiceUser();
//            User user = service.findById(idUser);
//            Competition c = new Competition(idCompetition,user , Titre, Description, TypeDeTalent, DateDebut, DateFin, Cout);
//            User u = new User(idUser, Nom, Prenom, Email, Login, MotDePasse, Sexe, DateNaissance, NumTelephone, TypeCompte, TypeTalent, Imguser);
//            arr.add(c);
//            arr2.add(u);
//            map.put(u,c);
//        }
//        
//            return map;
//        }

        @Override
        public Competition findByComp(Competition c) throws SQLException {
            String req = "select * from competition where idCompetition = ?";
            Competition competition = null;
            try {
                PreparedStatement ps = con.prepareStatement(req);
                 ps.setInt(1, c.getIdCompetition());
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
               
                int idUser = resultSet.getInt(2);
                ServiceUser ser = new ServiceUser();
                User u=ser.findById(idUser);
                    competition = new Competition(resultSet.getInt(1),u, resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),resultSet.getString(9));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return competition;
        }
        
        public Competition findById(int idCompetition) throws SQLException {
            String req = "select * from competition where idCompetition = ?";
            Competition competition = null;
            try {
                PreparedStatement ps = con.prepareStatement(req);
                 ps.setInt(1, idCompetition);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
               
                int idUser = resultSet.getInt(2);
                ServiceUser ser = new ServiceUser();
                User u=ser.findById(idUser);
                    competition = new Competition(resultSet.getInt(1),u, resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),resultSet.getString(9));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return competition;
        }
        
        
         public Boolean findBy(Competition c) throws SQLException {
        String req = "SELECT Titre, Description\n"
                + "  FROM Competition\n"
                + " WHERE Titre = ? AND Description = ?";

        PreparedStatement ps = con.prepareStatement(req);
        ps.setString(1, c.getTitre());
        ps.setString(2, c.getDescription());
//        ps.setString(3, c.getTypeDeTalent());
//        ps.setString(4, c.getDateDebut());
//        ps.setString(5, c.getDateFin());
//        
//        ps.setInt(6, c.getCout());

        ResultSet rs = ps.executeQuery();
        if (rs.next() == true) {
            System.out.println("Competition found !");
            return true;
        }
        System.out.println("Competition doesnt exist !");
        return false;
    }
         
         
         public List<Competition> readAll1() throws SQLException {
        List<Competition> arr = new ArrayList<>();

        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from competition");
        while (rs.next()) {
            int idCompetition = rs.getInt("idCompetition");
            
            int idUser = rs.getInt(2);
                ServiceUser ser = new ServiceUser();
                User u=ser.findById(idUser);
            String Titre = rs.getString("Titre");
            String Description = rs.getString("Description");
            String TypeDeTalent = rs.getString("TypeDeTalent");
            String DateDebut = rs.getString("DateDebut");
            String DateFin = rs.getString("DateFin");
            int Cout = rs.getInt("Cout");
            String image=rs.getString("imageC");
     
            Competition c = new Competition(idCompetition,u,Titre, Description, TypeDeTalent, DateDebut, DateFin, Cout,image);

            arr.add(c);

        }

        return arr;
    }
         
//         public Competition findById(int idCompetition) throws SQLException {
//            String req = "select * from competition where idCompetition = ?";
//            Competition competition = null;
//            try {
//                PreparedStatement ps = con.prepareStatement(req);
//                 ps.setInt(1, idCompetition);
//                ResultSet resultSet = ps.executeQuery();
//                if (resultSet.next()) {
//               
//                int idUser = resultSet.getInt(2);
//                ServiceUser ser = new ServiceUser();
//                User u=ser.findById(idUser);
//                    competition = new Competition(resultSet.getInt(1),u, resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return competition;
//        }
         
        @Override
        public ArrayList<Competition> findByTalent
        (String Talents) throws SQLException {
            String req = "select * from competition where TypeDeTalent = ?";
            ArrayList<Competition> arr1 = new ArrayList<>();
            try {
                PreparedStatement ps = con.prepareStatement(req);
                ps.setString(1, Talents);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idCompetition = rs.getInt(1);
                    int idUser = rs.getInt(2);
                    String Titre = rs.getString("Titre");
                    String Description = rs.getString("Description");
                    String TypeDeTalent = rs.getString("TypeDeTalent");
                    String DateDebut = rs.getString("DateDebut");
                    String DateFin = rs.getString("DateFin");
                    int Cout = rs.getInt("Cout");
                    String image=rs.getString("imageC");
                    Competition c = new Competition(idCompetition, User.class.cast(idUser), Titre, Description, TypeDeTalent, DateDebut, DateFin, Cout,image);
                    arr1.add(c);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return arr1;

        }
        
         public Competition findByTitre(String titre) {
        String req = "select * from competition where Titre = ? ";
         Competition comp2= new Competition();
        try{
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(1, titre);
            ResultSet resultSet = ps.executeQuery();
            
           
            if (resultSet.next()) {
            int idcomp = resultSet.getInt(1);
            int idUser = resultSet.getInt(2);
            ServiceUser ser1=new ServiceUser();
            User u=ser1.findById(idUser);
            ServiceCompetition ser2= new ServiceCompetition();
            comp2 =ser2.findById(idcomp);
            
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comp2;

}
        
        public List<String> Select() throws SQLException {
        String req = "select Titre from competition ";
        List<String> arr = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(req);
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               String Titre = rs.getString("Titre");
                arr.add(Titre);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;

    }
        
        public Competition SelectTitre(String titre) throws SQLException {
        String req = "select * from competition WHERE Titre=? ";
        
        
        
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(1, titre);
            Competition comp = new Competition();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idComp = rs.getInt("idCompetition");
                ServiceCompetition serC=new ServiceCompetition();
                comp=serC.findById(idComp);
               
                
            }

        
        return comp;

    }

    }
