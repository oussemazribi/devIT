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
public class Competition {
    
    int idCompetition ;
    int idUser;
    String titre;
    String description;
    String typeDeTalent;
    Date DateDebut;
    Date DateFin;
    int cout;
    String imageC;

    public Competition(int idCompetition, int idUser, String titre, String description, String typeDeTalent, int cout, String imageC) {
        this.idCompetition = idCompetition;
        this.idUser = idUser;
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.cout = cout;
        this.imageC = imageC;
    }

    public Competition(int idCompetition, int idUser, String titre, String description, String typeDeTalent, Date DateDebut, Date DateFin, int cout, String imageC) {
        this.idCompetition = idCompetition;
        this.idUser = idUser;
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.cout = cout;
        this.imageC = imageC;
    }
    public Competition()
            
    {
        
    }

    public Competition(String titre, String description, String typeDeTalent, int cout, String imageC) {
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.cout = cout;
        this.imageC = imageC;
    }

    public Competition(String titre, String description, Date DateDebut, Date DateFin, int cout, String imageC) {
        this.titre = titre;
        this.description = description;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.cout = cout;
        this.imageC = imageC;
    }

    public Competition(String titre, String description, String typeDeTalent, Date DateDebut, Date DateFin, int cout, String imageC) {
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.cout = cout;
        this.imageC = imageC;
    }
    

    public Competition(int idUser, String titre, String description, String typeDeTalent, Date DateDebut, Date DateFin, int cout, String imageC) {
        this.idUser = idUser;
        this.titre = titre;
        this.description = description;
        this.typeDeTalent = typeDeTalent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.cout = cout;
        this.imageC = imageC;
    }
    
    

    public int getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeDeTalent() {
        return typeDeTalent;
    }

    public void setTypeDeTalent(String typeDeTalent) {
        this.typeDeTalent = typeDeTalent;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date DateDebut) {
        this.DateDebut = DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date DateFin) {
        this.DateFin = DateFin;
    }

  

   

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public String getImageC() {
        return imageC;
    }

    public void setImageC(String imageC) {
        this.imageC = imageC;
    }

    @Override
    public String toString() {
        return "Competition{" + "idCompetition=" + idCompetition + ", idUser=" + idUser + ", titre=" + titre + ", description=" + description + ", typeDeTalent=" + typeDeTalent + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", cout=" + cout + ", imageC=" + imageC + '}';
    }
    
    
    
    
}
