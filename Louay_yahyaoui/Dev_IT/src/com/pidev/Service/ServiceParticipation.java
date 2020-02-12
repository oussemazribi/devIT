/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Service;

import com.pidev.Entite.Competition;
import com.pidev.Entite.Participation;
import com.pidev.Entite.Ticket;
import com.pidev.Entite.User;
import com.pidev.IService.IServiceParticipation;
import com.pidev.Test.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loume78
 */
public class ServiceParticipation implements IServiceParticipation<Participation> {

    private Connection con;
    private Statement ste;

    public ServiceParticipation() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Participation t) throws SQLException {

        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`participation` (`idCompetition` , `idUser`) VALUES ('" + t.getIdCompetition() + "', '" + t.getIdUser() + "');";
        ste.executeUpdate(requeteInsert);

    }

    @Override
    public boolean delete(Participation t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottalent`.`participation` where idCompetition =?");
        pre.setInt(1, t.getIdCompetition());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A participation was deleted successfully!");
        }
        return true;
    }

    public boolean update(int idCompetition, Participation p) throws SQLException {
        String sql = "UPDATE participation SET idCompetition=? WHERE idCompetition=?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, idCompetition);
        statement.setInt(2, p.getIdCompetition());
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing Participation was updated successfully!");
        }
        return true;
    }

    @Override
    public Map<User, Competition> readAll() throws SQLException {
        List<Competition> arr = new ArrayList<>();
        List<User> arr2 = new ArrayList<>();
        Map<User, Competition> map = new HashMap<>();

        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * \n"
                + "FROM competition INNER JOIN user \n"
                + "ON competition.idUser = user.idUser;");
        while (rs.next()) {
            int idCompetition = rs.getInt("idCompetition");
            int idUser1 = rs.getInt("idUser");

            String Titre = rs.getString("Titre");
            String Description = rs.getString("Description");
            String TypeDeTalent = rs.getString("TypeDeTalent");
            String Nom = rs.getString("Nom");
            String Prenom = rs.getString("Prenom");
            String Imguser = rs.getString("Imguser");
            Competition c = new Competition(idCompetition, idUser1, Titre, Description, TypeDeTalent);
            User u = new User(Nom, Prenom, Imguser);
            arr.add(c);
            arr2.add(u);
            map.put(u, c);
        }

        return map;
    }

    public List<Competition> findByIdUser(int idUser) throws SQLException {
        List<Competition> arr = new ArrayList<>();
        String req = "select * from participation where idUser = ?";
        Competition competition = null;
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, idUser);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                competition = new Competition(resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8));
                arr.add(competition);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public List<User> findByIdCompetition(int idCompetition) throws SQLException {
        String req = "SELECT * FROM participation\n"
                + "INNER JOIN user\n"
                + "ON participation.idUser = user.idUser \n"
                + "WHERE participation.idCompetition = ?;";
        List<User> arr = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, idCompetition);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String Nom = rs.getString("Nom");
                String Prenom = rs.getString("Prenom");
                String TypeDeTalent = rs.getString("TypeTalent");
                String ImgUser = rs.getString("ImgUser");
                User u = new User(Nom, Prenom, TypeDeTalent, ImgUser);
                arr.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;

    }

    public Boolean findById(int idCompetition, int idUser) throws SQLException {
        String req = "select * from participation where idUser = ? And idCompetition=?";

        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, idUser);
        ps.setInt(2, idCompetition);
        ResultSet rs = ps.executeQuery();
        if (rs.next() == true) {
            System.out.println("user found !");
            return true;
            
        }
        System.out.println("user doesnt exist !");
        return false;
    }
    
    
    

    public void ParticiperCompetition(int idCompetition, int idUser) throws SQLException {
        ServiceParticipation s = new ServiceParticipation();
        ServiceCompetition s1 = new ServiceCompetition();
        ServiceTicket s2 = new ServiceTicket();
        ServiceUser s3 = new ServiceUser();
        User u = new User();

        if (s.findById(idCompetition, idUser) == true) {
            System.out.println("vous etes deja participé ! ");

        } else {
            Competition c = s1.findById(idCompetition);
            u = s3.findById(idUser);
            System.out.println(u);
            if (u.getNbDiament() > c.getCout()) {
                s3.update(u.getNom(), u.getPrenom(), u.getEmail(), u.getLogin(), u.getMotDePasse(), u.getSexe(),
                        u.getDateNaissance(), u.getNumTelephone(), u.getTypeCompte(),
                        u.getTypeTalent(), u.getImguser(), u.getNbDiament() - c.getCout(), idUser);
                Participation p;
                ajouter(p = new Participation(idCompetition, idUser));
                Ticket t;
                String Code="U19" + u.getIdUser() + "C20" + c.getIdCompetition();
 
                
                s2.ajouter(t = new Ticket(idCompetition, idUser, "haha", Code));
            } else {
                System.out.println("vous n avez pas le nombre de diaments exacte !! ");
            }

//            System.out.println(20);
//            String louay = u.getSexe().substring(2, 3);
//            System.out.println(louay);

        }

    }
    
    
    
    
    

    public void VerifierTicket(int idUser, int idCompetition, String MotDePasse) {
        ServiceUser s1 = new ServiceUser();
        ServiceTicket s2 = new ServiceTicket();
        boolean test = false;
        try {
            test = s2.findByMDP2(MotDePasse);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParticipation.class.getName()).log(Level.SEVERE, null, ex);
        }
        Ticket tik = new Ticket();
        tik = s2.findByMDP(MotDePasse);

        if (test == false) {
            System.err.println("wrong password");

        } else {
            System.err.println("Loading");
            if (tik.getIdUser() == idUser) {
                System.err.println("Loading");

                if (tik.getIdCompetition() == idCompetition) {
                    System.out.println("je vous souhaite la bienvenue ! ");

                } else {
                    System.err.println("cette ticket appartient a un autre evenement");
                }
            } else {
                System.err.println("erreur");
            }
        }

    }
    
    
    
    

}
