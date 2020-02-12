/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Conversation;
import com.esprit.Entite.Message;
import com.esprit.IService.IServiceC;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class ServiceConversation implements IServiceC<Conversation> {

    private Connection con;
    private Statement ste;

    public ServiceConversation() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter(Conversation c) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `dev-it`.`conversation` (`idConversation`,`nom`, `DateCreation`, `id_Me`, `idU_Friend`) VALUES (NULL, '" + c.getNom() + "',NOW() ,'" + c.getId_Me() + "' ,'" + c.getIdU_Friend() + "');";
        ste.executeUpdate(requeteInsert);
    }
       public boolean deleteAd(int idConversation ) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `dev-it`.`conversation` where idConversation =?");
        pre.setInt(1, idConversation);
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A conversation was deleted successfully!");
        }
        return true;
    }

  /* public boolean deleteC(int idConversation ) throws SQLException {
        
        PreparedStatement pre = con.prepareStatement("DELETE `dev-it`.`conversation` , `dev-it`.`message` from `dev-it`.`conversation`inner join `dev-it`.`message` ON conversation.idConversation =message.id_Conversation");
        pre.setInt(1, idConversation);
        int id_Conversation = pre.get("id_Conversation") ;
        pre.setInt(2, id_Conversation);
         
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A message was deleted successfully!");
        }
        return true;
    }
    /* public boolean deleteall(int idConversation) throws SQLException {
         
         if (deleteC(idConversation)== true)
             delete(id_Message) ;
     }
       return true;
     }
*/

    @Override
    public boolean update(String nom, int id_Me, int idU_Friend, int idConversation) throws SQLException {
        String sql = "UPDATE Conversation SET nom=?, id_Me=?, idU_Friend=? WHERE idConversation=?";

        PreparedStatement statement = con.prepareStatement(sql);

        statement.setString(1, nom);
        statement.setInt(2, id_Me);
        statement.setInt(3, idU_Friend);
        statement.setInt(4, idConversation);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
        return true;
    }

    /*
    public List<Conversation> readAll() throws SQLException {
        List<Conversation> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from conversation");
        while (rs.next()) {
            int idConversation = rs.getInt(1);
            String nom = rs.getString(2);
            Timestamp DateCreation = rs.getTimestamp(3);
           
            int id_Me = rs.getInt(4);
            int idU_Friend = rs.getInt(5);
            Conversation c = new Conversation(idConversation, nom, DateCreation, id_Me ,idU_Friend);
            arr.add(c);
        }
        return arr;
    }
     */
    @Override
    public Map<Conversation, Message> readMessage() throws SQLException {
        List<Conversation> arr = new ArrayList<>();
        List<Message> arr1 = new ArrayList<>();
         
    
        Map<Conversation, Message> mapM = new HashMap<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from conversation INNER JOIN Message ON conversation.idConversation = Message.id_Conversation   ");
        while (rs.next()) {
            int idConversation = rs.getInt("idConversation");
            String nom = rs.getString("nom");
            Timestamp DateCreation = rs.getTimestamp("DateCreation");

            int id_Me = rs.getInt("id_Me");
            int idU_Friend = rs.getInt("idU_Friend");
          

            int id = rs.getInt("id_Message");
            int id_sender = rs.getInt("id_sender");
            int id_Receiver = rs.getInt("id_Receiver");
            String contenu = rs.getString("contenu");
            String etat = rs.getString("etat");
            Timestamp Date_Message = rs.getTimestamp("Date_Message");
            int id_Conversation = rs.getInt("id_Conversation");
              Conversation c = new Conversation(idConversation, nom, DateCreation, id_Me, idU_Friend);
            Message m = new Message(id, id_sender, id_Receiver, contenu, etat, Date_Message, id_Conversation);

            arr1.add(m);
            arr1.sort(new Comparator<Message>()
        {
            @Override
            public int compare ( Message e1 , Message e2)
            {
                return e1.getDate_Message().compareTo(e2.getDate_Message());
            }
        }) ;
           

            arr.add(c);
            mapM.put(c, m);

        }
        return mapM;
    }
    /*
    public List<Message> readorder() throws SQLException {
        List<Message> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from message order by Date_Message DESC ");
        while (rs.next()) {
            int id = rs.getInt(1);
            int id_sender = rs.getInt(2);
            int id_Receiver = rs.getInt(3);
            String contenu = rs.getString(4);
            String etat = rs.getString(5);
            Timestamp Date_Message = rs.getTimestamp(6);
            int id_Conversation = rs.getInt(7);
            Message m = new Message(id, id_sender, id_Receiver, contenu ,etat,Date_Message,id_Conversation);
            arr.add(m);
        }
        return arr;
    }
     */

}
