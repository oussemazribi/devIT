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
import com.pidev.IService.IServiceTicket;
import com.pidev.Test.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author loume78
 */
public class ServiceTicket implements IServiceTicket<Ticket> {

    
     private Connection con;
    private Statement ste;

    public ServiceTicket() {
        con = DataBase.getInstance().getConnection();

    }
    
    @Override
    public void ajouter(Ticket t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`ticket` (`idTicket` ,`idCompetition`, `idUser`, `Photo`, `MotDePasse`, `DateEmission` ) VALUES (NULL, '" + t.getCompetition().getIdCompetition()+ "','" + t.getUser().getIdUser()+ "'  , '" + t.getPhoto()+ "' , '" + t.getMotDePasse()+ "' , NOW() );";
        ste.executeUpdate(requeteInsert);
        
    }
    
    public boolean ajouter1(Ticket p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `tunisiangottalent`.`ticket` ( `idTicket`, `idCompetition`, `idUser`, `Photo`, `MotDePasse`,`DateEmission`) VALUES ( ?, ?, ?, ?, ?, ?);");
        pre.setInt(1, p.getCompetition().getIdCompetition());
        pre.setInt(1, p.getUser().getIdUser());
        pre.setString(2, p.getPhoto());
        pre.setString(3, p.getMotDePasse());
        pre.setDate(4, (Date) p.getDateEmission());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A Ticket was added successfully!");
        }
        return true;
        
    }

    @Override
    public boolean delete(Ticket t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottalent`.`ticket` where MotDePasse =?");
        pre.setString(1, t.getMotDePasse());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A Ticket was deleted successfully!");
        }
        return true;
        
    }

   
    @Override
    public List<Ticket> readAll() throws SQLException {
       List<Ticket> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from ticket");
        while (rs.next()) {
            int idTicket = rs.getInt(1);
            int idCompetition = rs.getInt(2);
            int idUser = rs.getInt(3);
            ServiceUser ser1 = new ServiceUser();
            User user2=ser1.findById(idUser);
            ServiceCompetition ser2= new ServiceCompetition();
            Competition comp2 =ser2.findById(idCompetition);
            String Photo = rs.getString("Photo");
            String MotDePasse = rs.getString("MotDePasse");
            Timestamp DateEmission = rs.getTimestamp("DateEmission");
            Ticket c = new Ticket(idTicket,comp2, user2, Photo, MotDePasse, DateEmission);
            arr.add(c);
        }
        return arr;
    }
    
    public Ticket findById(int idTicket) {
        String req = "select * from ticket where idTicket = ?";
        Ticket ticket = null;
        try{
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, idTicket);
            ResultSet resultSet = ps.executeQuery();
            int idCompetition = resultSet.getInt(2);
            int idUser = resultSet.getInt(3);
            ServiceUser ser1 = new ServiceUser();
            User user2=ser1.findById(idUser);
            ServiceCompetition ser2= new ServiceCompetition();
            Competition comp2 =ser2.findById(idCompetition);
            if (resultSet.next()) {
                ticket = new Ticket(comp2,user2, resultSet.getString(4), resultSet.getString(5),resultSet.getDate(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;

}
    
    public Ticket findByMDP(String MotDePasse) {
        String req = "select * from ticket where MotDePasse = ?";
        Ticket ticket=new Ticket();
        try{
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(1, MotDePasse);
            
            ResultSet resultSet = ps.executeQuery();
            
           
            if (resultSet.next()) {
            int idCompetition = resultSet.getInt("idCompetition");
            ServiceCompetition ser2= new ServiceCompetition();
            Competition comp2 =ser2.findById(idCompetition);
            int idUser = resultSet.getInt("idUser");
            ServiceUser ser1 = new ServiceUser();
            User user2=ser1.findById(idUser);
            ticket= new Ticket(comp2,user2, resultSet.getString(4), resultSet.getString(5),resultSet.getDate(6));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;

}
    
    public Ticket findBy(Competition comp , User user) {
        String req = "select * from ticket where idCompetition = ? AND idUser = ?";
        Ticket ticket=new Ticket();
        try{
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, comp.getIdCompetition());
            ps.setInt(2, user.getIdUser());
            
            ResultSet resultSet = ps.executeQuery();
            
           
            if (resultSet.next()) {
                int idTicket = resultSet.getInt(1);
            int idCompetition = resultSet.getInt("idCompetition");
            ServiceCompetition ser2= new ServiceCompetition();
            Competition comp2 =ser2.findById(idCompetition);
            int idUser = resultSet.getInt("idUser");
            ServiceUser ser1 = new ServiceUser();
            User user2=ser1.findById(idUser);
            ticket= new Ticket(idTicket,comp2,user2, resultSet.getString(4), resultSet.getString(5),resultSet.getDate(6));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;

}
 
     public boolean findByBoolean(Competition comp , User user) throws SQLException {
        String req = "select * from ticket where idCompetition = ? AND idUser = ?";
       
        
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, comp.getIdCompetition());
            ps.setInt(2, user.getIdUser());
            
            ResultSet resultSet = ps.executeQuery();
            
           
            if (resultSet.next()) {
                System.out.println("Ticket found !");
            return true;
            }
            
        System.out.println("Ticket doesnt exist !");
        return false;

}
     
    public Boolean findByMDP2(String MotDePasse1) throws SQLException {
        String req = "select * from ticket where MotDePasse = ?";

        PreparedStatement ps = con.prepareStatement(req);
        ps.setString(1, MotDePasse1);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next() == true) {
            System.out.println("Ticket found !");
            return true;
        }
        System.out.println("Ticket doesnt exist !");
        return false;
    }

    

}
