/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Service;

import com.pidev.Entite.Competition;
import com.pidev.Entite.Ticket;
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
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`ticket` (`idTicket` ,`idCompetition`, `idUser`, `Photo`, `MotDePasse`, `DateEmission` ) VALUES (NULL, '" + t.getIdCompetition()+ "','" + t.getIdUser()+ "'  , '" + t.getPhoto()+ "' , '" + t.getMotDePasse()+ "' , NOW() );";
        ste.executeUpdate(requeteInsert);
        
    }
    
    public boolean ajouter1(Ticket p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `tunisiangottalent`.`ticket` ( `idTicket`, `idCompetition`, `idUser`, `Photo`, `MotDePasse`,`DateEmission`) VALUES ( ?, ?, ?, ?, ?, ?);");
        pre.setInt(1, p.getIdCompetition());
        pre.setInt(1, p.getIdUser());
        pre.setString(2, p.getPhoto());
        pre.setString(3, p.getMotDePasse());
        pre.setDate(3, (Date) p.getDateEmission());
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
            int idCompetition = rs.getInt(2);
            int idUser = rs.getInt(3);
            String Photo = rs.getString("Photo");
            String MotDePasse = rs.getString("MotDePasse");
            Timestamp DateEmission = rs.getTimestamp("DateEmission");
            Ticket c = new Ticket(idCompetition, idUser, Photo, MotDePasse, DateEmission);
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
            if (resultSet.next()) {
                ticket = new Ticket(resultSet.getInt(2),resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5),resultSet.getDate(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;

}
    
    public Ticket findByMDP(String MotDePasse) {
        String req = "select * from ticket where MotDePasse = ?";
        Ticket ticket = null;
        try{
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(1, MotDePasse);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                ticket = new Ticket(resultSet.getInt(2),resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5),resultSet.getDate(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;

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
