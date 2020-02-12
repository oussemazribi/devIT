/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connexion.Basedonnees;
import entities.Publication;
import interfaceservice.IServices;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author asus
 */
public class ServicePublication implements IServices<Publication> {
    private Connection con;
    private Statement ste;

    public ServicePublication() {
        con = Basedonnees.getInstance().getConnection();

    }

    @Override
    public void ajouter(Publication t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`publications` (`id`, `id_author`, `date`, `type`,`contenu`,`visibilite`,`description`) VALUES (NULL,'" + t.getId_auteur()+ "',NOW(),'"+t.gettype() +"','"+t.getcontenu()+"','"+t.getvisibilite()+"','"+t.getdescription()+"');";
        ste.executeUpdate(requeteInsert);
    }
   public void ajouter1(Publication p) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `tunisiangottalent`.`publications` (`id`, `id_author`, `date`, `type`,`contenu`,`visibilite`,`description`) VALUES ( ? , ? , ? ,? , ? , ? , ?);");
    pre.setInt(1, p.getId());
    pre.setInt(2, p.getId_auteur());
    pre.setDate(3, p.getdate());
    pre.setString(4,p.gettype());
    pre.setString(5,p.getcontenu());
    pre.setInt(6,p.getvisibilite());
    pre.setString(7,p.getdescription());
    pre.executeUpdate();
    }
            

    @Override
    public boolean supprimer(Publication t) throws SQLException {
    PreparedStatement pre=con.prepareStatement("DELETE FROM `tunisiangottalent`.`publications` WHERE id=? ");
    pre.setInt(1,t.getId());
    pre.executeUpdate();
    int rowDeleted=pre.executeUpdate();
    if(rowDeleted>0)
    {
        System.out.println("a post has been deleted");
    }
    return true;
    }

    @Override
    public boolean modifier(Publication t) throws SQLException {
          String sql = "UPDATE `tunisiangottalent`.`Publications` SET type=?,contenu=?, visibilite=?,description=?  WHERE id=? ";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1,t.gettype());
        statement.setString(2,t.getcontenu());
        statement.setInt(3,t.getvisibilite());
        statement.setString(4,t.getdescription());
        statement.setInt(5, t.getId());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing Post was updated successfully!");
        }
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publication> readAll() throws SQLException {
    List<Publication> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from publications");
     while (rs.next()) {                
               int id=rs.getInt(1);
               int id_auteur=rs.getInt(2);
               Date date=rs.getDate(3);
               String type=rs.getString("type");
               String contenu=rs.getString(5);
               int visibilite=rs.getInt(6);
               String description=rs.getString(7);
               Publication p=new Publication(id,id_auteur,date,type,contenu,visibilite,description);
     arr.add(p);
     }
    return arr;
    }

    @Override
    public Publication rechercher(int a) throws SQLException {
        ste = con.createStatement();
        Publication P=new Publication();
        ResultSet rs = ste.executeQuery("select * from publications where id='"+a+"';");
             while (rs.next()) {    
        int id=rs.getInt(1);
               int id_auteur=rs.getInt(2);
               Date date=rs.getDate(3);
               String type=rs.getString("type");
               String contenu=rs.getString(5);
               int visibilite=rs.getInt(6);
               String description=rs.getString(7);
               P.setId(id);
               P.setId_auteur(id_auteur);
               P.setdate(date);
               P.setdescription(description);
               P.settype(type);
               P.setvisibilite(visibilite);
             }
           
        return P;
    }

    @Override
    public List<Publication> readAllsorted() throws SQLException 
    {
           List<Publication> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from publications order by date");
     while (rs.next()) {                
               int id=rs.getInt(1);
               int id_auteur=rs.getInt(2);
               Date date=rs.getDate(3);
               String type=rs.getString("type");
               String contenu=rs.getString(5);
               int visibilite=rs.getInt(6);
               String description=rs.getString(7);
               Publication p=new Publication(id,id_auteur,date,type,contenu,visibilite,description);
     arr.add(p);
     }
    return arr;
    }


    
}
