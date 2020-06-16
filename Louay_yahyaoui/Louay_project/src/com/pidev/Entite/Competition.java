/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Entite;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author loume78
 */
public class Competition {
    int idCompetition ;
    User user;
    String titre;
    String description;
    String typeDeTalent;
    String DateDebut;
    String DateFin;
    int cout;
    String imageC;

   

    public String getImageC() {
        return imageC;
    }

    public void setImageC(String imageC) {
        this.imageC = imageC;
    }

    public Competition(int idCompetition, User user, String titre, String description, String typeDeTalent, String DateDebut, String DateFin, int cout, String imageC) {
        this.idCompetition = idCompetition;
        this.user = user;
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.cout = cout;
        this.imageC = imageC;
    }

    public Competition(User user, String titre, String description, String typeDeTalent, String DateDebut, String DateFin, int cout, String imageC) {
        this.user = user;
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.cout = cout;
        this.imageC = imageC;
    }
    
    

    public Competition(String titre, String description, String typeDeTalent, String DateDebut, String DateFin, int cout) {
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.cout = cout;
    }

    public Competition(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    
    
    public Competition( User user, String titre, String description, String typeDeTalent, String DateDebut, String DateFin, int cout) {
       
        this.user = user;
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.cout = cout;
    }
    

    public Competition(int idCompetition, User user, String titre, String description, String typeDeTalent, String DateDebut, String DateFin, int cout) {
        this.idCompetition = idCompetition;
        this.user = user;
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.cout = cout;
    }
    

    public Competition(int idCompetition, User user, String titre, String description, String typeDeTalent) {
        this.idCompetition = idCompetition;
        this.user = user;
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
    }
    
    

    

    public Competition() {
    }

    public int getIdCompetition() {
        return idCompetition;
    }

    public User getUser() {
        return user;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeDeTalent() {
        return typeDeTalent;
    }

    public String getDateDebut() {
        return DateDebut;
    }

    public String getDateFin() {
        return DateFin;
    }

    public int getCout() {
        return cout;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    public void setIdUser(User user) {
        this.user = user;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeDeTalent(String typeDeTalent) {
        this.typeDeTalent = typeDeTalent;
    }

    public void setDateDebut(String DateDebut) {
        this.DateDebut = DateDebut;
    }

    public void setDateFin(String DateFin) {
        this.DateFin = DateFin;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Competition other = (Competition) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Competition{" + "idCompetition=" + idCompetition + ", idUser=" + user + ", titre=" + titre + ", description=" + description + ", typeDeTalent=" + typeDeTalent + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", cout=" + cout + '}';
    }
    
    
    
    
    
}
