/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Entite;

import com.sun.glass.ui.SystemClipboard;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author loume78
 */
public class Ticket {
    
    int idTicket;
    Competition comp;
    User user;
    String photo;
    String motDePasse;
   
    Date dateEmission ;
    
    public Ticket(){}

    public Ticket( Competition comp, User user, String photo, String motDePasse, Date DateEmission) {
        
        this.comp = comp;
        this.user = user;
        this.photo = photo;
        this.motDePasse = motDePasse;
        this.dateEmission=DateEmission;
        
    }
    public Ticket( Competition comp, User user, String photo, String motDePasse) {
        
        this.comp = comp;
        this.user = user;
        this.photo = photo;
        this.motDePasse = motDePasse;
        
        
    }

    public Ticket(int idTicket, Competition comp, User user, String photo, String motDePasse, Date dateEmission) {
        
        this.comp = comp;
        this.user = user;
        this.photo = photo;
        this.motDePasse = motDePasse;
        
    }

    public Ticket(int idTicket, Competition comp, User user, String photo, String motDePasse) {
        this.idTicket = idTicket;
        this.comp = comp;
        this.user = user;
        this.photo = photo;
        this.motDePasse = motDePasse;
    }

    
    

    public int getIdTicket() {
        return idTicket;
    }

    public Competition getCompetition() {
        return comp;
    }

    public User getUser() {
        return user;
    }

    public String getPhoto() {
        return photo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public void setIdCompetition(Competition comp) {
        this.comp = comp;
    }

    public void setIdUser(User user) {
        this.user = user;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        if (this.motDePasse != other.motDePasse) {
            return false;
        }
        if (!Objects.equals(this.dateEmission, other.dateEmission)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ticket{" + "idTicket=" + idTicket + ", idCompetition=" + comp + ", idUser=" + user + ", photo=" + photo + ", motDePasse=" + motDePasse + ", dateEmission=" + dateEmission + '}';
    }
    
    
    
}
