/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Entite;

import java.util.Date;
import com.pidev.Entite.Talents;
import java.util.Objects;

/**
 *
 * @author loume78
 */
public class Competition {
    int idCompetition ;
    int idUser;
    String titre;
    String description;
    String typeDeTalent;
    String DateDebut;
    String DateFin;
    int cout;

    public Competition( int idUser, String titre, String description, String typeDeTalent, String DateDebut, String DateFin, int cout) {
       
        this.idUser = idUser;
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.cout = cout;
    }
    

    public Competition(int idCompetition, int idUser, String titre, String description, String typeDeTalent, String DateDebut, String DateFin, int cout) {
        this.idCompetition = idCompetition;
        this.idUser = idUser;
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.cout = cout;
    }

    public Competition(int idCompetition, int idUser, String Titre, String Description, String TypeDeTalent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Competition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdCompetition() {
        return idCompetition;
    }

    public int getIdUser() {
        return idUser;
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

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
        return "Competition{" + "idCompetition=" + idCompetition + ", idUser=" + idUser + ", titre=" + titre + ", description=" + description + ", typeDeTalent=" + typeDeTalent + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", cout=" + cout + '}';
    }
    
    
    
    
    
}
