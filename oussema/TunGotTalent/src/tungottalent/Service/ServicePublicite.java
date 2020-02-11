/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungottalent.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tungottalent.Entite.Annonce;
import tungottalent.Entite.Publicite;
import tungottalent.IService.IServicePublicite;
import tungottalent.Utils.DataBase;

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
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`publicite` ( `idAnnonce`, `idUser`, `DateDebut`,`DateFin`,`Etat`,`prix`) VALUES ('" + p.getIdAnnonce() + "', '" + p.getIdUser() + "','" + p.getDateDebut() + "','" + p.getDateFin()+ "','" + p.getEtat() + "','" + p.getPrix()+ "');";
        ste.executeUpdate(requeteInsert);
        
//        PreparedStatement pre = con.prepareStatement("INSERT INTO `tunisiangottalent`.`publicite` ( `idAnnonce`, `idUser`, `DateDebut`,`DateFin`,`Etat`,`Cout`) VALUES ( ?, ?, ?, ?, ?, ?);");
//        pre.setInt(1, p.getIdAnnonce());
//        pre.setInt(2, p.getIdUser());
//        pre.setDate(3, (java.sql.Date) p.getDateDebut());
//        pre.setDate(4, (java.sql.Date) p.getDateFin());
//        pre.setString(5, p.getEtat());
//        pre.setFloat(6, p.getCout());
//        pre.executeUpdate();
    }

    @Override
    public boolean delete(Publicite p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottalent`.`publicite` where idAnnonce =?");
        pre.setInt(1, p.getIdAnnonce());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
        return true;
    }

    @Override
    public boolean update(Date DateDebut, Date DateFin, String Etat, float Prix, Publicite p) throws SQLException {
        String sql = "UPDATE personne SET DateDebut=?, DateFin=?, Etat=? , Prix=? WHERE idAnnonce=?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setDate(1, (java.sql.Date) DateDebut);
        statement.setDate(2, (java.sql.Date) DateFin);
        statement.setString(3, Etat);
        statement.setFloat(4, Prix);
        statement.setInt(5, p.getIdAnnonce());

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
            String DateDebut = rs.getString(3);
            String DateFin = rs.getString(4);
            String Etat = rs.getString(5);
            float Prix = rs.getFloat(6);
            Publicite p = new Publicite(idAnnonce, idUser, DateDebut, DateFin, Etat ,Prix);
            arr.add(p);
        }
        return arr;
    }

}
