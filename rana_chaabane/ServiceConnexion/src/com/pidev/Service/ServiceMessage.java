/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Service;

import com.pidev.Entite.Message;
import com.pidev.IService.IService;
import com.pidev.Entite.User;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.pidev.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author House
 */
public class ServiceMessage implements IService<Message> {

    private Connection con;
    private Statement ste;

    public ServiceMessage() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Message t) throws SQLException {
        System.err.println(t.getContenu());
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `dev-it`.`message`  (`id_Message`,`id_Sender`, `id_Receiver`, `Contenu`, `Etat`, `Date_Message`, `id_Conversation`) VALUES (NULL, '" + t.getId_Sender() + "', '" + t.getId_Receiver() + "', '" + t.getContenu() + "', '" + t.getEtat() + "', NOW() ,'" + t.getId_Conversation() + "');";
        ste.executeUpdate(requeteInsert);
    }

    /*
      public void ajouter(Message t) throws SQLException {
        System.err.println(t.getContenu());
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `message` (`id_Message`, `id_Sender`, `id_Receiver`, `Contenu`, `Etat`, `Date_Message`, `id_Conversation`) VALUES (NULL, '1', '2', '"+t.getContenu()+"', 'Not_Seen', NOW(), '28');";
        ste.executeUpdate(requeteInsert);
    }
     */

 /* public void ajouter1(Message p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `esprit1`.`personne` ( `nom`, `prenom`, `age`) VALUES ( ?, ?, ?);");
        pre.setString(1, p.getNom());
        pre.setString(2, p.getPrenom());
        pre.setInt(3, p.getAge());
        pre.executeUpdate();
    }
     */
    @Override
    public boolean delete(int id_Message) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `dev-it`.`message` where id_Message =?");
        pre.setInt(1, id_Message);
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A message was deleted successfully!");
        }
        return true;
    }

    public boolean transfer(int id_Message, int id_Conversation1) throws SQLException {
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());

        String sql = "UPDATE message SET Date_Message=?, id_Conversation=? WHERE id_Message=?";
        System.out.println(id_Conversation1);
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setTimestamp(1, date);
        System.err.println(date);
        statement.setInt(2, id_Conversation1);
        statement.setInt(3, id_Message);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
        return true;
    }

    public boolean SeenMessage(int id_Message) throws SQLException {

        String sql = "UPDATE message SET etat=? WHERE id_Message=?";

        PreparedStatement statement = con.prepareStatement(sql);
        String etat = "Now_Seen";
        statement.setString(1, etat);
        statement.setInt(2, id_Message);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
        return true;
    }

    @Override
    public List<Message> readAll() throws SQLException {
        List<Message> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from message");
        while (rs.next()) {
            int id = rs.getInt(1);
            int id_sender = rs.getInt(2);
            int id_Receiver = rs.getInt(3);
            String contenu = rs.getString(4);
            String etat = rs.getString(5);
            Timestamp Date_Message = rs.getTimestamp(6);
            int id_Conversation = rs.getInt(7);
            Message m = new Message(id, id_sender, id_Receiver, contenu, etat, Date_Message, id_Conversation);
            arr.add(m);
        }
        return arr;
    }

    public List<Message> recherche(String recherche) throws SQLException {

        ArrayList<Message> tab = new ArrayList();

        try {

            PreparedStatement statement = con.prepareStatement("select Contenu.* from message where Contenu=?  ");

            statement.setString(1, recherche);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);

                int id_sender = rs.getInt(2);
                int id_Receiver = rs.getInt(3);
                String contenu = rs.getString(4);
                String etat = rs.getString(5);
                Timestamp Date_Message = rs.getTimestamp(6);
                int id_Conversation = rs.getInt(7);
                Message m = new Message(id, id_sender, id_Receiver, contenu, etat, Date_Message, id_Conversation);

                tab.add(m);
                System.err.println(m);

            }
        } catch (SQLException ex) {

        }
        return tab;
    }

    public List<Message> readorder() throws SQLException {
        List<Message> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from message");
        while (rs.next()) {
            int id = rs.getInt(1);
            int id_sender = rs.getInt(2);
            int id_Receiver = rs.getInt(3);
            String contenu = rs.getString(4);
            String etat = rs.getString(5);
            Timestamp Date_Message = rs.getTimestamp(6);
            int id_Conversation = rs.getInt(7);
            Message m = new Message(id, id_sender, id_Receiver, contenu, etat, Date_Message, id_Conversation);
            arr.add(m);
        }
        return arr;
    }

    @Override
    public List<Message> messageenvoyees(User u, int idconversation) throws SQLException {
        int iduser = u.getIdUser();
        ArrayList<Message> tab = new ArrayList();

        try {

            PreparedStatement statement = con.prepareStatement("select * from message where  id_Conversation=? ");
           statement.setInt(1, idconversation);
        


            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);

                int id_sender = rs.getInt(2);
                int id_Receiver = rs.getInt(3);
                String contenu = rs.getString(4);
                String etat = rs.getString(5);
                Timestamp Date_Message = rs.getTimestamp(6);
            
                Message m = new Message(id, id_sender, id_Receiver, contenu, etat, Date_Message, idconversation);

                tab.add(m);
               //s System.out.println(tab);

            }
        } catch (SQLException ex) {

        }
        return tab;
    }

    public long countNbUnreadConversations(int iduser) throws SQLException {
        long x = 0;
        String sql = "SELECT COUNT(*) FROM message WHERE id_Sender=? or id_Receiver=?  ";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, iduser);
            statement.setInt(2, iduser);

            ResultSet res = statement.executeQuery();

            while (res.next()) {

                x = res.getLong(1);

            }
        } catch (SQLException ex) {

        }

        System.err.println(x);

        return x;
    }

}
