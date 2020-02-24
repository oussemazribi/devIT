/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.pidev.Entite.Annonce;
import com.pidev.Entite.Publicite;
import com.pidev.Entite.User;
import com.pidev.IService.IServicePublicite;
import com.pidev.Utils.DataBase;

/**
 *
 * @author ousse
 */
public class ServicePublicite implements IServicePublicite<Publicite> {

    private Connection con;
    private Statement ste;

    public ServicePublicite() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Publicite p) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`publicite` ( `idAnnonce`, `idUser`, `DateDebut`,`DateFin`,`Etat`,`pack`) VALUES ('" + p.getAnnonce().getIdAnnonce() + "', '" + p.getUser().getIdUser() + "','" + p.getDateDebut() + "','" + p.getDateFin() + "','" + p.getEtat() + "','" + p.getPack() + "');";
        ste.executeUpdate(requeteInsert);

    }

         public void ajouter1(Publicite p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `tunisiangottalent`.`publicite` (`idAnnonce`, `idUser`, `DateDebut`,`DateFin`,`Etat`,`pack`,`prix`) VALUES ( ?, ?, ?, ?, ?, ?,?);");
        pre.setInt(1, p.getAnnonce().getIdAnnonce());
        pre.setInt(2, p.getUser().getIdUser());
        pre.setDate(3, (java.sql.Date) p.getDateDebut());
        pre.setDate(4, (java.sql.Date) p.getDateFin());
        pre.setString(5,p.getEtat());
        pre.setString(6,p.getPack());
        pre.setFloat(7,p.getPrix());
        
        pre.executeUpdate();
    }
     
    
    @Override
    public boolean delete(Publicite p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottalent`.`publicite` where idAnnonce =?");
        pre.setInt(1, p.getAnnonce().getIdAnnonce());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
        return true;
    }

    @Override
    public boolean update(Date DateDebut, Date DateFin, String Etat, String Pack, Publicite p) throws SQLException {
        String sql = "UPDATE publicite SET DateDebut=?, DateFin=?, Etat=? , Pack=? WHERE idAnnonce=?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setDate(1, (java.sql.Date) DateDebut);
        statement.setDate(2, (java.sql.Date) DateFin);
        statement.setString(3, Etat);
        statement.setString(4, Pack);
        statement.setInt(5, p.getAnnonce().getIdAnnonce());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
        return true;
    }

    @Override
    public List<Publicite> readAll() throws SQLException {
        List<Publicite> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from publicite");
        while (rs.next()) {
            int idAnnonce = rs.getInt(1);
            int idUser = rs.getInt(2);
            ServiceUser ser = new ServiceUser();
            User u = ser.findById(idUser);
            ServiceAnnonce ser1 = new ServiceAnnonce();
            Annonce a = ser1.findById(idAnnonce);
            Date DateDebut = rs.getDate(3);
            Date DateFin = rs.getDate(4);
            String Etat = rs.getString(5);
            String Pack = rs.getString(6);
            Publicite p = new Publicite(a,u, DateDebut, DateFin, Etat, Pack);
            arr.add(p);
        }
        return arr;
    }

    public boolean deleteDate(Date DateFin, Publicite p) throws SQLException {
        if (DateFin == p.getDateFin()) {
            PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottalent`.`publicite` where idAnnonce =?");
            pre.setInt(1, p.getAnnonce().getIdAnnonce());
            pre.executeUpdate();
            int rowsDeleted = pre.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }

        }
        return true;
    }

    public boolean promotion(int pourcentage, Publicite p) throws SQLException {

        String sql = "UPDATE publicite SET Prix=? WHERE idAnnonce=?";

        PreparedStatement statement = con.prepareStatement(sql);
        float pr = (pourcentage * p.getPrix() / 100);
        float nouvPrix = (p.getPrix() - pr);
        statement.setFloat(1, nouvPrix);
        System.out.println(nouvPrix);
        statement.setInt(2, p.getAnnonce().getIdAnnonce());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing publicite was updated successfully!");
        }
        return true;
    }

    public ArrayList<Publicite> findByPack(String Pack) throws SQLException {
        String req = "select * from publicite where pack = ?";
        ArrayList<Publicite> arr1 = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(1, Pack);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idAnnonce = rs.getInt(1);
                int idUser = rs.getInt(2);
                ServiceUser ser = new ServiceUser();
                User u = ser.findById(idUser);
                ServiceAnnonce ser1 = new ServiceAnnonce();
                Annonce a = ser1.findById(idAnnonce);

                Date DateDebut = rs.getDate("DateDebut");
                Date DateFin = rs.getDate("DateFin");
                String Etat = rs.getString("Etat");
                Publicite c = new Publicite(a, u, DateDebut, DateFin, Etat, Pack);
                arr1.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr1;

    }

}
