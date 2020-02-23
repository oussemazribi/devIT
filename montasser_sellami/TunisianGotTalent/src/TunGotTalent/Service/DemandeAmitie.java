/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TunGotTalent.Service;

import TunGotTalent.IService.IServiceUser;
import TunGotTalent.entities.Amitie;
import TunGotTalent.entities.User;
import TunGotTalent.utils.DataBase;
import java.sql.Connection;
import java.sql.Statement;


public class DemandeAmitie  {
    private Connection con;
     private Statement ste;
        public DemandeAmitie() {
        con = DataBase.getInstance().getConnection();
        }

        public void ajouterD(int idUser1){
String req = "INSERT INTO 'Amitie' ('idUser1' , 'idUser2', 'Etat', 'SenderId' , 'BlockId'  )";

        }
 



}
