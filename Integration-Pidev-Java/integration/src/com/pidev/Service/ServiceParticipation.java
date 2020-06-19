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
import com.pidev.Utils.DataBase;
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
import java.util.Random;
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
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`participation` (`idCompetition` , `idUser`) VALUES ('" + t.getCompetition().getIdCompetition() + "', '" + t.getUser().getIdUser() + "');";
        ste.executeUpdate(requeteInsert);

    }

    @Override
    public boolean delete(Participation t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottalent`.`participation` where idCompetition =?");
        pre.setInt(1, t.getCompetition().getIdCompetition());
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
        statement.setInt(2, p.getCompetition().getIdCompetition());
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing Participation was updated successfully!");
        }
        return true;
    }

//    @Override
//    public Map<User, Competition> readAll() throws SQLException {
//        List<Competition> arr = new ArrayList<>();
//        List<User> arr2 = new ArrayList<>();
//        Map<User, Competition> map = new HashMap<>();
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
//            String Nom = rs.getString("Nom");
//            String Prenom = rs.getString("Prenom");
//            String Imguser = rs.getString("Imguser");
//            ServiceUser service = new ServiceUser();
//            User user = service.findById(idUser1);
//            Competition c = new Competition(idCompetition, user, Titre, Description, TypeDeTalent);
//            User u = new User(Nom, Prenom, Imguser);
//            arr.add(c);
//            arr2.add(u);
//            map.put(u, c);
//        }
//
//        return map;
//    }

    public List<Competition> findByIdUser(User user) throws SQLException {
        List<Competition> arr = new ArrayList<>();
        String req = "select * from participation where idUser = ?";
        Competition competition = null;
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, user.getIdUser());
            ResultSet resultSet = ps.executeQuery();
            ServiceUser service = new ServiceUser();
            int id = resultSet.getInt("idUser");
            User user1 = service.findById(id);
            int idUser1 = resultSet.getInt(2);
            if (resultSet.next()) {
                competition = new Competition(resultSet.getInt(1),user1, resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getString(9));
                arr.add(competition);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public List<Competition> findByRechercher(User user) throws SQLException {
        List<Competition> arr = new ArrayList<>();
        String req = "select * from participation where idUser = ?";
        Competition competition = null;
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, user.getIdUser());
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int idComp = resultSet.getInt("idCompetition");
                ServiceCompetition ser2 = new ServiceCompetition();
                Competition comp = ser2.findById(idComp);
                arr.add(comp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }

    public List<String> Lawejli(User user) throws SQLException {
        List<String> arr = new ArrayList<>();
        String req = "select * from participation where idUser = ?";
        Competition competition = null;
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, user.getIdUser());
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int idCompetition = resultSet.getInt("idCompetition");
                ServiceCompetition ser2 = new ServiceCompetition();
                Competition comp2 = ser2.findById(idCompetition);

                String Titre = comp2.getTitre();
                arr.add(Titre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public List<User> findByIdCompetition(Competition comp) throws SQLException {
        String req = "SELECT * FROM participation\n"
                + "INNER JOIN user\n"
                + "ON participation.idUser = user.idUser \n"
                + "WHERE participation.idCompetition = ?;";
        List<User> arr = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, comp.getIdCompetition());
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

    public Boolean findById(Competition comp, User user) throws SQLException {
        String req = "select * from participation where idUser = ? And idCompetition=?";

        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, user.getIdUser());
        ps.setInt(2, comp.getIdCompetition());
        ResultSet rs = ps.executeQuery();
        if (rs.next() == true) {
            System.out.println("user found !");
            return true;

        }
        System.out.println("user doesnt exist !");
        return false;
    }

    public String GeneratMyCode() {

        Random rand = new Random();
        int myrand = rand.nextInt(1000000) + 10205;
        String code = Integer.toString(myrand);
        return code;
    }

    public void ParticiperCompetition(Competition comp, User user) throws SQLException {
        ServiceParticipation s = new ServiceParticipation();
        ServiceCompetition s1 = new ServiceCompetition();
        ServiceTicket s2 = new ServiceTicket();
        ServiceUser s3 = new ServiceUser();
        User u = new User();

        if (s.findById(comp, user) == true) {
            System.out.println("vous etes deja participé ! ");

        } else //            Competition c = s1.findById(comp.getIdCompetition());
        //            u = s3.findById(user.getIdUser());
        ////            System.out.println(u);
        {
            if (user.getNbDiament() > comp.getCout()) {
                s3.update(user.getNom(), user.getPrenom(), user.getEmail(), user.getLogin(), user.getMotDePasse(), user.getSexe(),
                        user.getDateNaissance(), user.getNumTelephone(), user.getTypeCompte(),
                        user.getTypeTalent(), user.getImguser(), user.getNbDiament() - comp.getCout(), user.getIdUser());
                Participation p;
                ajouter(p = new Participation(comp, user));
                if (s2.findByBoolean(comp, user) == true) {
                    System.out.println("ticket pret !");
                } else {
                    Ticket t;
                    String Code = GeneratMyCode();

                    s2.ajouter(t = new Ticket(comp, user, "haha", Code));

                }

            } else {
                System.out.println("vous n avez pas le nombre de diaments exacte !! ");
            } //            System.out.println(20);        //            String louay = u.getSexe().substring(2, 3);
        }        //            System.out.println(louay);

    }

    public void VerifierTicket(User u, Competition c1, String MotDePasse) {
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
            System.err.println("Mot de passe incorrecte");

        } else {
            System.err.println("chargement...");
            if (tik.getUser().getIdUser() == u.getIdUser()) {

                if (tik.getCompetition().getIdCompetition() == c1.getIdCompetition()) {
                    System.out.println("je vous souhaite la bienvenue ! ");

                } else {
                    System.err.println("cette ticket appartient a un autre evenement");
                }
            } else {
                System.err.println("verifier votre ticket");
            }
        }

    }

    public User RechercheByIdCompetition(Competition comp) throws SQLException {
        String req = "select * from ticket where idCompetition = ?";
        User user = new User();

        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, comp.getIdCompetition());

        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12), resultSet.getInt(13));
            System.out.println(user);
        }

        return user;

    }

}
