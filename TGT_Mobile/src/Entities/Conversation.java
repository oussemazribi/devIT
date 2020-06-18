/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.util.Date;
/**
 *
 * @author HP
 */
public class Conversation {
         private int idConversation;
        private String Nom	;
     private Date DateCreation;
     private int id_Me=1;
    private int idU_Friend;
    public Conversation() {
    }
    @Override
    public String toString() {
        return "Conversation{" + "idConversation=" + idConversation + ", Nom=" + Nom + ", DateCreation=" + DateCreation + ", id_Me=" + id_Me + ", idU_Friend=" + idU_Friend + '}';
    }
    public Conversation(String Nom, Date DateCreation, int id_Me, int idU_Friend) {
        this.Nom = Nom;
        this.DateCreation = DateCreation;
        this.id_Me = id_Me;
        this.idU_Friend = idU_Friend;
    }
    public int getIdConversation() {
        return idConversation;
    }
    public void setIdConversation(int idConversation) {
        this.idConversation = idConversation;
    }
    public String getNom() {
        return Nom;
    }
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    public Date getDateCreation() {
        return DateCreation;
    }
    public void setDateCreation(Date DateCreation) {
        this.DateCreation = DateCreation;
    }
    public int getId_Me() {
        return id_Me;
    }
    public void setId_Me(int id_Me) {
        this.id_Me = id_Me;
    }
    public int getIdU_Friend() {
        return idU_Friend;
    }
    public void setIdU_Friend(int idU_Friend) {
        this.idU_Friend = idU_Friend;
    }
}