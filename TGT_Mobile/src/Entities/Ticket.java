/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author loume78
 */
public class Ticket {
    
    int idTicket;
    int comp;
    int user;
    String photo;
    String motDePasse;
   
    Date dateEmission ;

    public Ticket(int comp, int user) {
        this.comp = comp;
        this.user = user;
    }

    
    
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getComp() {
        return comp;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public Ticket() {
    }

    public Ticket(int comp, int user, String photo, String motDePasse, Date dateEmission) {
        this.comp = comp;
        this.user = user;
        this.photo = photo;
        this.motDePasse = motDePasse;
        this.dateEmission = dateEmission;
    }

    public Ticket(int idTicket, int comp, int user, String photo, String motDePasse, Date dateEmission) {
        this.idTicket = idTicket;
        this.comp = comp;
        this.user = user;
        this.photo = photo;
        this.motDePasse = motDePasse;
        this.dateEmission = dateEmission;
    }

    @Override
    public String toString() {
        return "Ticket{" + "idTicket=" + idTicket + ", comp=" + comp + ", user=" + user + ", photo=" + photo + ", motDePasse=" + motDePasse + ", dateEmission=" + dateEmission + '}';
    }
    
    

    
}
