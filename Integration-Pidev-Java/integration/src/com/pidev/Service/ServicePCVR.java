/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Service;
import com.pidev.Utils.DataBase;
import java.util.Map;
import java.util.HashMap;
import com.pidev.Entite.Vote;
import com.pidev.Entite.Reaction;
import com.pidev.Entite.Commentaire;
import com.pidev.Entite.Publication;
import com.pidev.IService.ISERPub;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author asus
 */
public class ServicePCVR implements ISERPub<Publication,Commentaire,Vote,Reaction>{
            private Connection con;
            private Statement ste;

    public ServicePCVR() {
        con = DataBase.getInstance().getConnection();

    }
            @Override
    public Map<Publication, Commentaire> readcomments() throws SQLException {
        List<Publication> arr = new ArrayList<>();
        List<Commentaire> arr1 = new ArrayList<>();
        Map<Publication, Commentaire> mapM = new HashMap<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from post INNER JOIN commentaire ON post.id = commentaire.id_post ");
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
               int idC=rs.getInt(10);
               int id_user=rs.getInt(11);
               int id_publication=rs.getInt(12);
               String contenue=rs.getString(13);
               Date dateC=rs.getDate(14);

            Publication p=new Publication(id,id_auteur,date,type,contenu,titre,nbcomments,nbreacts,nbvotes);
            Commentaire m = new Commentaire(idC, id_user, id_publication, contenue,dateC);

            arr1.add(m);

            arr.add(p);
            mapM.put(p, m);

        }
        return mapM;
    }



    @Override
    public Map<Publication, Vote> showvotes() throws SQLException {
        List<Publication> arr = new ArrayList<>();
        List<Vote> arr1 = new ArrayList<>();
        Map<Publication, Vote> mapV = new HashMap<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from post JOIN vote ON post.id = vote.id_post ");
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
               int id_user=rs.getInt(10);
               int id_publication=rs.getInt(11);
               Date dateR=rs.getDate(12);
               int typeR=rs.getInt(13);

           Publication p=new Publication(id,id_auteur,date,type,contenu,titre,nbcomments,nbreacts,nbvotes);
            Vote  v = new Vote(id_user, id_publication,dateR,typeR);

            arr1.add(v);

            arr.add(p);
            mapV.put(p,v);

        }
        return mapV;
    }
    

    @Override
    public Map<Publication, Reaction> showreaction() throws SQLException {
        List<Publication> arr = new ArrayList<>();
        List<Reaction> arr1 = new ArrayList<>();
        Map<Publication, Reaction> mapR = new HashMap<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from post INNER JOIN reaction ON post.id = reaction.id_publication ");
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
               int id_user=rs.getInt(8);
               int id_publication=rs.getInt(9);
               Date dateR=rs.getDate(10);
               int typeR=rs.getInt(10);

            Publication p=new Publication(id,id_auteur,date,type,contenu,titre,nbcomments,nbreacts,nbvotes);
            Reaction  m = new Reaction(id_user, id_publication,dateR,typeR);

            arr1.add(m);

            arr.add(p);
            mapR.put(p,m);

        }
        return mapR;
    }
    @Override
    public List<Commentaire> commentofpost(int id) throws SQLException {
        List<Commentaire> arr1 = new ArrayList<>();
        Map<Publication, Commentaire> mapM = new HashMap<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from commentaire where id_post='"+id+"' ");
        while (rs.next()) {

               int idC=rs.getInt(1);
               int id_user=rs.getInt(4);
               int id_publication=rs.getInt(2);
               String contenue=rs.getString(3);
               Date dateC=rs.getDate(5);
               Commentaire m = new Commentaire(idC, id_user, id_publication, contenue,dateC);

            arr1.add(m);
           

        }
        return arr1;
       
    }

    @Override
    public List<Publication> mostvoted() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publication> mostreacted() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countkol() throws SQLException {
        int nbups = 0;
        ste = con.createStatement();
       
        ResultSet rs = ste.executeQuery("SELECT COUNT(id) FROM post;");
        while (rs.next()) {    
                nbups=rs.getInt(1);
        
        }
        return nbups;
    }
    
}