/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Commentaire;
import entities.Publication;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import entities.Reaction;
import entities.Vote;

 


/**
 *
 * @author asus
 */
import java.text.SimpleDateFormat;
import java.util.Map;
public class test {
        public static void main(String[] args) throws ParseException, SQLException {
        ServicePublication ser = new ServicePublication();
        ServiceReaction serr=new ServiceReaction();
        ServiceVote serv=new ServiceVote();
        ServicePCVR sc=new ServicePCVR();
        ServiceCommentaire serc =new ServiceCommentaire();
        String date="21-12-2000";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed;
            parsed = format.parse("2011-02-10");
        java.sql.Date sql = new java.sql.Date(parsed.getDate());
        Publication p1 = new Publication(1,sql,"type","contenu",1,"description");
        Publication p2 = new Publication(1,sql,"type","contenu",1,"description");
        Publication p3 = new Publication(1,sql,"type","contenu",1,"description");
        Reaction r1=new Reaction(1,5,sql,1);
        Reaction r2=new Reaction(1,6,sql,1);
        Reaction r3=new Reaction(1,7,sql,2);
        Vote v1=new Vote(1,5,sql,1);
        Vote v2=new Vote(1,6,sql,1);
        Vote v3=new Vote(1,7,sql,2);
        Commentaire c1= new Commentaire(1,1,5,"cldmlf",sql);
        Commentaire c2= new Commentaire(1,1,7,"cldmlf",sql);
        Commentaire c3= new Commentaire(1,1,8,"cldmlf",sql);
        
        
        
        
        
        try {
//         
            System.out.println(" CRUD Publications******************************:");
            ser.ajouter(p1);
            p1.setId(30);
            p1.setdescription("lolo");
            if (ser.modifier(p1))
                System.out.println("Publication modifiée");
            else 
                System.out.println("publication non modifiée");
            if(ser.supprimer(p1))
                System.out.println("Pulication Supprimée");
            else 
                System.out.println("Publication non Supprimée");
            
            System.out.println(" CRUD Commentaires******************************:");
            serc.ajouter(c1);
            c1.setcontenu("yeah");
            if (serc.modifier(c1))
                System.out.println("commentaire modifié");
            else 
                System.out.println("Commentaire non Modifié");
            if(serc.supprimer(c1))
                System.out.println("Commentaire supprimé");
            else 
                System.out.println("Commentaire non supprimé");
                
            
            System.out.println(" CRUD Vote******************************:");
            serv.ajouter(v1);
            v1.settype(5);
            if(serv.modifier(v1))
                System.out.println("Vote Modifiée");
            else 
                System.out.println("Vote non Modifiée");
            if(serv.supprimer(v1))
                System.out.println("Vote supprimée");
            else 
                System.out.println("Votee non supprimé");
           System.out.println(" CRUD Reaction******************************:");
            serr.ajouter(r1);
            r1.settype(5);
            if(serr.modifier(r1))
                System.out.println("Reaction Modifiée");
            else 
                System.out.println("Reaction non Modifiée");
            if (serr.supprimer(r1))
                     System.out.println("Reaction supprimée");
            else 
                System.out.println("Reaction non supprimée");
            
            
            System.out.println("publications******************************:");
            List<Publication> list = ser.readAll();
            System.out.println(list);
            System.out.println("Reactions******************************:");
            List<Reaction> list1=serr.readAll();
            System.out.println(list1);
            System.out.println("Commentaires******************************:");
            List<Commentaire> list2=serc.readAll();
            System.out.println(list2);
            System.out.println("Votes******************************:");
            List<Vote> list3=serv.readAll();
            System.out.println(list3);  
            
           System.out.println("Commentaires & Publiction******************************:");
           Map<Publication,Commentaire> MapM = sc.readcomments();
           MapM.entrySet().stream().forEach((Ha) -> {
               System.err.println(""+Ha.getKey()+""+Ha.getValue());
            });
           System.out.println("Reactions & Publication:******************************:");
               Map<Publication,Reaction> MapR = sc.showreaction();
           MapR.entrySet().stream().forEach((Ha) -> {
               System.err.println(""+Ha.getKey()+""+Ha.getValue());
            });
          System.out.println("Votes & Publication:******************************:");
            Map<Publication,Vote> Mapv = sc.showvotes();
             for (Map.Entry<Publication,Vote>  Ha : Mapv.entrySet())
            System.err.println(Ha.getKey()+""+Ha.getValue());
             
           System.out.println("Metiers:******************************:");
            System.out.println("Most commented:******************************:");
            List<Publication> list5=sc.mostcommented();
            System.out.println(list5);  
            System.out.println("Most reacted:******************************:");
            List<Publication> list6=sc.mostreacted();
            System.out.println(list6);  
            System.out.println("Most voted:******************************:");
            List<Publication> list7=sc.mostreacted();
            System.out.println(list7); 
            System.out.println("Recherche par ID:******************************:");
            Publication p10=ser.rechercher(5);
            System.out.println(p10.toString());
            System.out.println("Triée:******************************:");
            List<Publication> list8=ser.readAllsorted();
            System.out.println(list8);
              ser.ajouter(p1);
              serc.ajouter(c3);
            
                    
            
            
         
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
