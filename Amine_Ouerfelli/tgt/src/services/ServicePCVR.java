/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Connexion.Basedonnees;
import java.util.Map;
import java.util.HashMap;
import entities.Vote;
import entities.Reaction;
import entities.Commentaire;
import entities.Publication;
import interfaceservice.ISERPub;
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
        con = Basedonnees.getInstance().getConnection();

    }
            @Override
    public Map<Publication, Commentaire> readcomments() throws SQLException {
        List<Publication> arr = new ArrayList<>();
        List<Commentaire> arr1 = new ArrayList<>();
        Map<Publication, Commentaire> mapM = new HashMap<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from Publications INNER JOIN Commentaire ON publications.id = Commentaire.idPublication ");
        while (rs.next()) {
               int id=rs.getInt(1);
               int id_auteur=rs.getInt(2);
               Date date=rs.getDate(3);
               String type=rs.getString("type");
               String contenu=rs.getString(5);
               int visibilite=rs.getInt(6);
               String description=rs.getString(7);
               int idC=rs.getInt(8);
               int id_user=rs.getInt(9);
               int id_publication=rs.getInt(10);
               String contenue=rs.getString(11);
               Date dateC=rs.getDate(12);

            Publication c = new Publication(id,id_auteur,date,type,contenu,visibilite,description);
            Commentaire m = new Commentaire(idC, id_user, id_publication, contenue,dateC);

            arr1.add(m);

            arr.add(c);
            mapM.put(c, m);

        }
        return mapM;
    }



    @Override
    public Map<Publication, Vote> showvotes() throws SQLException {
        List<Publication> arr = new ArrayList<>();
        List<Vote> arr1 = new ArrayList<>();
        Map<Publication, Vote> mapV = new HashMap<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from publications JOIN vote ON publications.id = vote.idpub ");
        while (rs.next()) {
               int id=rs.getInt(1);
               int id_auteur=rs.getInt(2);
               Date date=rs.getDate(3);
               String type=rs.getString("type");
               String contenu=rs.getString(5);
               int visibilite=rs.getInt(6);
               String description=rs.getString(7);
               int id_user=rs.getInt(8);
               int id_publication=rs.getInt(9);
               Date dateR=rs.getDate(10);
               int typeR=rs.getInt(10);

            Publication P = new Publication(id,id_auteur,date,type,contenu,visibilite,description);
            Vote  v = new Vote(id_user, id_publication,dateR,typeR);

            arr1.add(v);

            arr.add(P);
            mapV.put(P,v);

        }
        return mapV;
    }
    

    @Override
    public Map<Publication, Reaction> showreaction() throws SQLException {
        List<Publication> arr = new ArrayList<>();
        List<Reaction> arr1 = new ArrayList<>();
        Map<Publication, Reaction> mapR = new HashMap<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from Publications INNER JOIN reaction ON publications.id = reaction.id_publication ");
        while (rs.next()) {
               int id=rs.getInt(1);
               int id_auteur=rs.getInt(2);
               Date date=rs.getDate(3);
               String type=rs.getString("type");
               String contenu=rs.getString(5);
               int visibilite=rs.getInt(6);
               String description=rs.getString(7);
               int id_user=rs.getInt(8);
               int id_publication=rs.getInt(9);
               Date dateR=rs.getDate(10);
               int typeR=rs.getInt(10);

            Publication p = new Publication(id,id_auteur,date,type,contenu,visibilite,description);
            Reaction  m = new Reaction(id_user, id_publication,dateR,typeR);

            arr1.add(m);

            arr.add(p);
            mapR.put(p,m);

        }
        return mapR;
    }

    @Override
    public List<Publication> mostcommented() throws SQLException {
        ste = con.createStatement();
         List<Publication> arr=new ArrayList<>();
        ResultSet rs = ste.executeQuery("SELECT *,postcount FROM publications as p INNER JOIN (SELECT idPublication,count(*) AS postcount FROM commentaire GROUP BY idPublication) as c on p.id = idPublication Order by postcount DESC LIMIT 1 ");
         while (rs.next()) {    
               int id=rs.getInt(1);
               int id_auteur=rs.getInt(2);
               Date date=rs.getDate(3);
               String type=rs.getString("type");
               String contenu=rs.getString(5);
               int visibilite=rs.getInt(6);
               String description=rs.getString(7);
               int nb_comm=rs.getInt(8);
               int nbv=0;
               int nbreact=0;
               Publication p = new Publication(id,id_auteur,date,type,contenu,visibilite,description,nb_comm,nbv,nbreact);
               arr.add(p);
         }
          return arr;
    }

    @Override
    public List<Publication> mostvoted() throws SQLException {
        ste = con.createStatement();
        List<Publication> arr=new ArrayList<>();
        ResultSet rs = ste.executeQuery("SELECT *,postcount FROM publications as p INNER JOIN (SELECT idpub,count(*) AS postcount FROM vote GROUP BY idPublication) as v on p.id = idpub Order by postcount DESC LIMIT 1 ");
          while (rs.next()) { 
               int id=rs.getInt(1);
               int id_auteur=rs.getInt(2);
               Date date=rs.getDate(3);
               String type=rs.getString("type");
               String contenu=rs.getString(5);
               int visibilite=rs.getInt(6);
               String description=rs.getString(7);
               int nb_comm=rs.getInt(8);
               int nbv=0;
               int nbreact=0;


               Publication P = new Publication(id,id_auteur,date,type,contenu,visibilite,description,nb_comm,nbv,nbreact);
               arr.add(P);
          }
        return arr;

    }

    @Override
    public List<Publication> mostreacted() throws SQLException {
        ste = con.createStatement();
        List<Publication> arr=new ArrayList<>();
        ResultSet rs = ste.executeQuery("SELECT *,postcount FROM publications as p INNER JOIN (SELECT id_publication,count(*) AS postcount FROM reaction GROUP BY id_publication) as c on p.id = id_publication Order by postcount DESC LIMIT 1 ");
        while (rs.next()) {    
               int id=rs.getInt(1);
               int id_auteur=rs.getInt(2);
               Date date=rs.getDate(3);
               String type=rs.getString("type");
               String contenu=rs.getString(5);
               int visibilite=rs.getInt(6);
               String description=rs.getString(7);
               int nbreact=rs.getInt(8);
               int nbv=0;
               int nb_comm=0;


               Publication P = new Publication(id,id_auteur,date,type,contenu,visibilite,description,nb_comm,nbv,nbreact);
               arr.add(P);
        }
        return arr;
        
    }
}
