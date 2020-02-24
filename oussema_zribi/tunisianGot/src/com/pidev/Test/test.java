/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Test;

import java.sql.SQLException;
import java.util.List;

import com.pidev.Entite.Annonce;
import com.pidev.Entite.Publicite;
import com.pidev.Entite.User;
import com.pidev.Service.ServiceAnnonce;
import com.pidev.Service.ServicePublicite;
import com.pidev.Service.ServiceUser;

/**
 *
 * @author ousse
 */
public class test {

    public static void main(String[] args) {
        ServiceUser ser0 = new ServiceUser();
        ServiceAnnonce ser = new ServiceAnnonce();
        ServicePublicite ser1 = new ServicePublicite();

        User u1 = new User(6, "montasser", "sellami", "aaaa", "montinho", "aaaa", "homme", "1996", 10101010, "Administrateur", "Dance", "null");
        Annonce a1 = new Annonce(11, u1, "Guitarre", "Desctiption", 654, "Vendu");
     //   Publicite p1 = new Publicite(a1, u1, "date", "date1", "true", 500);

               List<Annonce> list;
        try {
            list = ser.readAll();
            System.out.println(list);
        } catch (SQLException ex) {
            System.out.println("erreur");
        }

        
        
    }

}
