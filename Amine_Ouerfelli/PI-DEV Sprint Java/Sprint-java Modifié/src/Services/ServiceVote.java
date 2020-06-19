/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Connexion.Basedonnees;
import entities.Publication;
import entities.Vote;
import entities.Vote;
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
public class ServiceVote implements IServices<Vote> {
    private Connection con;
    private Statement ste;

    public ServiceVote() {
        con = Basedonnees.getInstance().getConnection();

    }

    @Override
    public void ajouter(Vote t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`vote` (`idUser`, `id_post`, `valeur`,`Date`) VALUES ('"+ t.getiduser() + "', '" + t.getidpublication() + "', '" + t.getvaleur() + "',NOW());";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Vote v) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `tunisiangottalent`.`vote` ( `idUser`, `id_post`, `valeur`,`Date`) VALUES ( ?, ?, ? ,?);");
    pre.setInt(1, v.getiduser());
    pre.setInt(2,v.getidpublication());
    pre.setInt(3, v.getvaleur());
    pre.setDate(4, v.getdate());
    ServicePublication serp=new ServicePublication();
    Publication p=serp.rechercher(v.getidpublication());
    int nbrec=p.getNb_react();
    int newone=nbrec+1;
    PreparedStatement pre2=con.prepareStatement("UPDATE `tunisiangottalent`.`post` SET votess_on_post=?  WHERE id=? ");
    pre2.setInt(1, newone);
    pre.executeUpdate();
    }
            

    @Override
    public boolean supprimer(Vote t) throws SQLException {
         PreparedStatement pre=con.prepareStatement("DELETE FROM `tunisiangottalent`.`vote` where idUser= ? and id_post= ?");
    pre.setInt(1,t.getiduser());
    pre.setInt(2, t.getidpublication());
    pre.executeUpdate();
    ServicePublication serp=new ServicePublication();
    Publication p=serp.rechercher(t.getidpublication());
    int nbrec=p.getNb_react();
    int newone=nbrec+1;
    PreparedStatement pre2=con.prepareStatement("UPDATE `tunisiangottalent`.`post` SET votes_on_post=?  WHERE id=? ");
    pre2.setInt(1, newone);
    int rowDeleted=pre.executeUpdate();
    if(rowDeleted>0)
    {
        System.out.println("a vote has been deleted");
    }
    return true;
    }

    @Override
    public boolean modifier(Vote t) throws SQLException {

        String sql = "UPDATE `tunisiangottalent`.`vote` SET valeur=?, date=NOW() WHERE idUser=? and id_post=?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1,t.getvaleur());
        statement.setInt(2,t.getiduser());
        statement.setInt(3,t.getidpublication());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing vote was updated successfully!");
        }
        return true;
    }

    @Override
    public List<Vote> readAll() throws SQLException {
    List<Vote> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from  vote");
     while (rs.next()) {                
               
               int id_user=rs.getInt(2);
               int id_publication=rs.getInt(3);
               int valeur=rs.getInt(4);
               Date date=rs.getDate(5);
               Vote v=new Vote(id_user,id_publication,date,valeur);
     arr.add(v);
     }
    return arr;
    }

    @Override
    public Vote rechercher(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vote> readAllsorted() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vote> showpublicationbyuser(int a) throws SQLException {
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
    public List<Vote> showcommentsbypub(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vote> showMediabypost(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
