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
    int idCompetition;
    int idUser;
    String photo;
    String motDePasse;
   
    Date dateEmission ;
    
    public Ticket(){}

    public Ticket( int idCompetition, int idUser, String photo, String motDePasse, Date DateEmission) {
        
        this.idCompetition = idCompetition;
        this.idUser = idUser;
        this.photo = photo;
        this.motDePasse = motDePasse;
        this.dateEmission=DateEmission;
        
    }
    public Ticket( int idCompetition, int idUser, String photo, String motDePasse) {
        
        this.idCompetition = idCompetition;
        this.idUser = idUser;
        this.photo = photo;
        this.motDePasse = motDePasse;
        
        
    }

    public Ticket(int idTicket, int idCompetition, int idUser, String photo, String motDePasse, Date dateEmission) {
        
        this.idCompetition = idCompetition;
        this.idUser = idUser;
        this.photo = photo;
        this.motDePasse = motDePasse;
        
    }

    public Ticket(int idTicket, int idCompetition, int idUser, String photo, String motDePasse) {
        this.idTicket = idTicket;
        this.idCompetition = idCompetition;
        this.idUser = idUser;
        this.photo = photo;
        this.motDePasse = motDePasse;
    }

    
    

    public int getIdTicket() {
        return idTicket;
    }

    public int getIdCompetition() {
        return idCompetition;
    }

    public int getIdUser() {
        return idUser;
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

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
        return "Ticket{" + "idTicket=" + idTicket + ", idCompetition=" + idCompetition + ", idUser=" + idUser + ", photo=" + photo + ", motDePasse=" + motDePasse + ", dateEmission=" + dateEmission + '}';
    }
    
    
    
}
