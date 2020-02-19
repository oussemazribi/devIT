package tungottalent.test;

import java.sql.*;

import java.util.List;
import tungottalent.Entite.Annonce;
import tungottalent.Entite.CommentaireAnnonce;
import tungottalent.Entite.Publicite;
import tungottalent.Entite.User;
import tungottalent.Service.ServiceAnnonce;
import tungottalent.Service.ServiceCommentaireAnnonce;
import tungottalent.Service.ServicePublicite;

public class Test {

    public static void main(String[] args) {
        
        ServiceAnnonce ser = new ServiceAnnonce();
        ServicePublicite ser1 = new ServicePublicite();
        ServiceCommentaireAnnonce ser2 = new ServiceCommentaireAnnonce();

//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.YEAR, 2020);
//        cal.set(Calendar.MONTH, 6);
//        cal.set(Calendar.DATE, 20);
//        Date date = cal.getTime();
//        Calendar cal1 = Calendar.getInstance();
//        cal1.set(Calendar.YEAR, 2021);
//        cal1.set(Calendar.MONTH, 7);
//        cal1.set(Calendar.DATE, 25);
//        Date date1 = cal.getTime();
     User u1 = new User("montasser", "sellami", "aaaa", "montinho", "aaaa","homme", "1996", 10101010 ,"Administrateur" ,"Dance", "null");
       Annonce a1 = new Annonce(u1, "Guitarre", "Desctiption", 654, "Vendu");
        Publicite p1 = new Publicite(a1, u1, "date", "date1", "true", 546);

        // Annonce a2 = new Annonce(1234,"Trompone","Desctiption",784,"Disponble");
            CommentaireAnnonce c = new CommentaireAnnonce(u1,a1," GOOD","11-02-2020");
         
        try {
//         
          //  ser.ajouter(a1);
          //  ser1.ajouter(p1);
           // ser2.ajouter(c);

           // ser.delete(a1);
           // ser.delete(p1);
           // ser.delete(c);
         //  ser.update("Piano"," wwwwww ", 12233,"disponible");
          ser1.update("11-03-2020","12-03-2020","false",333,p1 );
         //  ser2.update(1,4,"GOOD !!!","12-03-2020", 8);
            List<CommentaireAnnonce> list2 = ser2.readAll();
            List<Publicite> list1 = ser1.readAll();
            List<Annonce> list = ser.readAll();
//            System.out.println(list);
            System.out.println(list2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
