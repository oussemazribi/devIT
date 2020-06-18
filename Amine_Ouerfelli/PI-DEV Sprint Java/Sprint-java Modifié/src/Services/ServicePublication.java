/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`post` (`id`,`date`, `type`,`contenue`,`titre`,`idUser`,`Reacts_on_post`,`votes_on_post`,`comments_on_post`) VALUES (NULL,NOW(),'"+t.gettype() +"','"+t.getcontenu()+"','"+t.gettitre()+"','" + t.getId_auteur()+ "','" + t.getNb_react()+"','" + t.getNb_vote()+ "','" + t.getNb_comm()+ "');";
        ste.executeUpdate(requeteInsert);
    }
   public void ajouter1(Publication p) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `tunisiangottalent`.`post` (`id`,`date`, `type`,`contenue`,`titre`,`idUser`,`Reacts_on_post`,`votes_on_post`,`comments_on_post`)VALUES ( ? , ? , ? ,? , ? , ? , ?,?,?);");
    pre.setInt(1, p.getId());
    pre.setDate(2, p.getdate());
    pre.setString(3,p.gettype());
    pre.setString(4,p.getcontenu());
    pre.setString(5,p.gettitre());
    pre.setInt(6,p.getId_auteur());
    pre.setInt(7,p.getNb_react());
    pre.setInt(8,p.getNb_vote());
    pre.setInt(9,p.getNb_comm());
    pre.executeUpdate();
    }
            

    @Override
    public boolean supprimer(Publication t) throws SQLException {
    PreparedStatement pre=con.prepareStatement("DELETE FROM `tunisiangottalent`.`post` WHERE id=? ");
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
          String sql = "UPDATE `tunisiangottalent`.`post` SET contenue=?, titre=?  WHERE id=? ";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1,t.getcontenu());
        statement.setString(2,t.gettitre());
        statement.setInt(3, t.getId());

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
    ResultSet rs=ste.executeQuery("select * from post");
     while (rs.next()) {    
               int id=rs.getInt(1);               
               Date date=rs.getDate(2);
               String type=rs.getString("type");
               String contenu=rs.getString(4);
               String titre=rs.getString(5);
               int id_auteur=rs.getInt(6);
               int nbreacts=rs.getInt(7);
               int nbcomments=rs.getInt(9);
               int nbvotes=rs.getInt(8);
               Publication p=new Publication(id,id_auteur,date,type,contenu,titre,nbcomments,nbreacts,nbvotes);
     arr.add(p);
     }
    return arr;
    }

    @Override
    public Publication rechercher(int a) throws SQLException {
        ste = con.createStatement();
        Publication P=new Publication();
        ResultSet rs = ste.executeQuery("select * from post where id='"+a+"';");
             while (rs.next()) {    
               int id=rs.getInt(1);               
               Date date=rs.getDate(2);
               String type=rs.getString("type");
               String contenu=rs.getString(4);
               String titre=rs.getString(5);
               int id_auteur=rs.getInt(6);
               int nbreacts=rs.getInt(7);
               int nbcomments=rs.getInt(9);
               int nbvotes=rs.getInt(8);
               P.setId(id);
               P.setId_auteur(id_auteur);
               P.setdate(date);
               P.settype(type);
               P.setcontenu(contenu);
               P.settitre(titre);
               P.setNb_comm(nbcomments);
               P.setNb_react(nbreacts);
               P.setNb_vote(nbvotes);
             }
           
        return P;
    }

    @Override
    public List<Publication> readAllsorted() throws SQLException 
    {
    List<Publication> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from post order by date");
     while (rs.next()) {                
            int id=rs.getInt(1);               
               Date date=rs.getDate(2);
               String type=rs.getString("type");
               String contenu=rs.getString(4);
               String titre=rs.getString(5);
               int id_auteur=rs.getInt(6);
               int nbreacts=rs.getInt(7);
               int nbcomments=rs.getInt(9);
               int nbvotes=rs.getInt(8);
               Publication p=new Publication(id,id_auteur,date,type,contenu,titre,nbcomments,nbreacts,nbvotes);
     arr.add(p);
     }
    return arr;
    }

    @Override
    public List<Publication> showpublicationbyuser(int a) throws SQLException {
                   List<Publication> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from post where idUser='"+a+"';");
     while (rs.next()) {                
               int id=rs.getInt(1);               
               Date date=rs.getDate(2);
               String type=rs.getString("type");
               String contenu=rs.getString(4);
               String titre=rs.getString(5);
               int id_auteur=rs.getInt(6);
               int nbreacts=rs.getInt(7);
               int nbcomments=rs.getInt(9);
               int nbvotes=rs.getInt(8);
               Publication p=new Publication(id,id_auteur,date,type,contenu,titre,nbcomments,nbreacts,nbvotes);
     arr.add(p);
     }
    return arr;
    }

    @Override
    public int calculatereacts(int a) throws SQLException {
        int nbreacts = 0;
        ste = con.createStatement();
       
        ResultSet rs = ste.executeQuery("select postcount FROM post as p INNER JOIN (SELECT id_post,count(*) AS postcount FROM reaction GROUP BY id_post) as v on p.id = id_post where p.id");
        while (rs.next()) {    
                nbreacts=rs.getInt(1);
        
        }
        return nbreacts;
    }

    @Override
    public int calculateups(int a) throws SQLException {
        int nbups = 0;
        ste = con.createStatement();
       
        ResultSet rs = ste.executeQuery("select postcount FROM post as p INNER JOIN (SELECT idpub,count(*) AS postcount FROM vote where type=1 GROUP BY idpub) as v on p.id = idpub where p.id='"+a+"';");
        while (rs.next()) {    
                nbups=rs.getInt(1);
        
        }
        return nbups;
    }

    @Override
    public int calculatedowns(int a) throws SQLException {
             int nbups = 0;
        ste = con.createStatement();
       
        ResultSet rs = ste.executeQuery("select postcount FROM post as p INNER JOIN (SELECT idpub,count(*) AS postcount FROM vote where valeur=2 GROUP BY idpub) as v on p.id = id_post where p.id='"+a+"';");
        while (rs.next()) {    
                nbups=rs.getInt(1);
        
        }
        return nbups;
    }

    @Override
    public List<Publication> showcommentsbypub(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publication> showMediabypost(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
