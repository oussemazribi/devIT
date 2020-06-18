/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Connexion.Basedonnees;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entities.Commentaire;
import entities.Publication;
import interfaceservice.IServices;
import java.sql.Date;

/**
 *
 * @author asus
 */
public class ServiceCommentaire implements IServices<Commentaire> {
    
    private Connection con;
    private Statement ste;

    public ServiceCommentaire() {
        con = Basedonnees.getInstance().getConnection();

    }

    @Override
    public void ajouter(Commentaire t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`commentaire` (`id`, `idUser`, `id_post`, `contenue`,`date`) VALUES (NULL, '" + t.getiduser() + "', '" + t.getidpublication() + "', '" + t.getcontenu() + "',NOW());";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Commentaire c) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `tunisiangottalent`.`commentaire` (`id`, `idUser`, `id_post`, `contenue`,`date`) VALUES (?,?,?,?,?);");
    pre.setInt(1, c.getid());
    pre.setInt(2, c.getiduser());
    pre.setInt(3,c.getidpublication());
    pre.setString(4, c.getcontenu());
    pre.setDate(5, c.getdate());
    pre.executeUpdate();
        ServicePublication serp=new ServicePublication();
    Publication p=serp.rechercher(c.getidpublication());
    int nbrec=p.getNb_react();
    int newone=nbrec+1;
    PreparedStatement pre2=con.prepareStatement("UPDATE `tunisiangottalent`.`post` SET comments_on_post=?  WHERE id=? ");
    pre2.setInt(1, newone);
    }
            

    @Override
    public boolean supprimer(Commentaire t) throws SQLException {
    PreparedStatement pre=con.prepareStatement("DELETE FROM `tunisiangottalent`.`commentaire` where idUser= ? and id_post= ? and id=?");
    pre.setInt(1,t.getiduser());
    pre.setInt(2, t.getidpublication());
    pre.setInt(3,t.getid());
    pre.executeUpdate();
    ServicePublication serp=new ServicePublication();
    Publication p=serp.rechercher(t.getidpublication());
    int nbrec=p.getNb_react();
    int newone=nbrec+1;
    PreparedStatement pre2=con.prepareStatement("UPDATE `tunisiangottalent`.`post` SET comments_on_post=?  WHERE id=? ");
    pre2.setInt(1, newone);
    int rowDeleted=pre.executeUpdate();
    if(rowDeleted>0)
    {
        System.out.println("a Comment has been deleted");
    }
    return true;
    }

    @Override
    public boolean modifier(Commentaire t) throws SQLException {
        String sql = "UPDATE `tunisiangottalent`.`commentaire` SET contenue=?, date=? WHERE idUser =? and id_post=? and id= ?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1,t.getcontenu());
        statement.setDate(2,t.getdate());
        statement.setInt(3,t.getiduser());
        statement.setInt(4,t.getidpublication());
        statement.setInt(5, t.getid());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing comment was updated successfully!");
        }
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> readAll() throws SQLException {
    List<Commentaire> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from commentaire");
     while (rs.next()) {                
               int id=rs.getInt(1);
               int id_user=rs.getInt(4);
               int id_publication=rs.getInt(2);
               String contenu=rs.getString(3);
               Date date=rs.getDate(5);
               Commentaire c=new Commentaire(id,id_user,id_publication,contenu,date);
     arr.add(c);
     }
    return arr;
    }

    @Override
    public Commentaire rechercher(int a) throws SQLException {
    
    ste=con.createStatement();
    Commentaire c=new Commentaire();
    ResultSet rs=ste.executeQuery("select * from commentaire where id='"+a+"';");
     while (rs.next()) {                
               int id=rs.getInt(1);
               int id_user=rs.getInt(4);
               int id_publication=rs.getInt(2);
               String contenu=rs.getString(3);
               Date date=rs.getDate(5);
               c.setcontenu(contenu);
               c.setid(id);
               c.setdate(date);
               c.setidpublication(id_publication);
               c.setiduser(id_user);
    }
    return c;
    }

    @Override
    public List<Commentaire> readAllsorted() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> showpublicationbyuser(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculatereacts(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculateups(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculatedowns(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> showcommentsbypub(int a) throws SQLException {
            List<Commentaire> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from commentaire where idPublication='"+a+"';");
     while (rs.next()) {                
               int id=rs.getInt(1);
               int id_user=rs.getInt(2);
               int id_publication=rs.getInt(3);
               String contenu=rs.getString(4);
               Date date=rs.getDate(5);
               Commentaire c=new Commentaire(id,id_user,id_publication,contenu,date);
     arr.add(c);
     }
    return arr;
    }

    @Override
    public List<Commentaire> showMediabypost(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
