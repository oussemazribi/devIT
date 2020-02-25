
package com.pidev.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.pidev.Entite.Reclamation;
import com.pidev.IService.IServiceReclamation;
import com.pidev.Utils.DataBase;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServiceReclamation implements IServiceReclamation<Reclamation> {

    private Connection con;
    private Statement ste;

    public ServiceReclamation() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Reclamation r) throws SQLException {
        ste = con.createStatement();

        String requeteInsert = "INSERT INTO `tunisiangottalent`.`reclamation` (`idUser`, `Objet`, `Description`,`Photo`,`Etat`,`DateReclamation`)  VALUES ('" + r.getIdUser() + "', '" + r.getObjet() + "', '" + r.getDescription() + "', '" +r.getPhoto()+ "','" + r.getEtat() + "', NOW() );";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete(Reclamation r) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottalent`.`reclamation` where Objet=? and idUser=?");
        pre.setString(1, r.getObjet());
        pre.setInt(2, r.getIdUser());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
        return true;
    }
    @Override
    public boolean update(String objet, String description, String photo, String Etat, Reclamation r) throws SQLException {
        String sql = "UPDATE reclamation SET objet=?, description=?, photo=?,Etat=? WHERE objet=?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, objet);
        statement.setString(2, description);
        statement.setString(3, photo);
        statement.setString(4, Etat);
        statement.setString(5, r.getObjet());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
        return true;
    }

    @Override
    public List<Reclamation> readAll() throws SQLException {
        List<Reclamation> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from reclamation");
        while (rs.next()) {
            int idUser = rs.getInt(1);
            String objet = rs.getString(2);
            String Description = rs.getString(3);
            String Photo = rs.getString(4);
            String Etat = rs.getString(5);
            Date dateReclamation = rs.getDate(6);
            Reclamation r = new Reclamation(idUser,objet, Description, Photo, Etat, dateReclamation);
            arr.add(r);
        }
        return arr;
    }

    @Override
    public Reclamation rechercher(int a) throws SQLException {
        Reclamation r=new Reclamation();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from reclamation where idUser='"+a+"' limit 1;");
                while (rs.next()) {
            int idUser = rs.getInt(1);
            String objet = rs.getString(2);
            String Description = rs.getString(3);
            String Photo = rs.getString(4);
            String Etat = rs.getString(5);
            Date dateReclamation = rs.getDate(6);
            r.setIdUser(idUser);
            r.setDateReclamation(dateReclamation);
            r.setEtat(Etat);
            r.setObjet(objet);
            r.setPhoto(Photo);
            r.setDescription(Description);
                }
                return r;
                
            
            
        }

    

}
