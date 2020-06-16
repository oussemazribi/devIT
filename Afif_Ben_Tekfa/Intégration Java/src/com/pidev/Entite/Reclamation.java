
package com.pidev.Entite;

import java.util.Date;

public class Reclamation {



    private int idUser;
    private String objet;
    private String description;
    private String photo;
    private String Etat;
    private Date dateReclamation;

    public Reclamation(int idUser, String objet, String description, String photo, String Etat) {
        this.idUser = idUser;
        this.objet = objet;
        this.description = description;
        this.photo = photo;
        this.Etat = Etat;
    }



    public Reclamation(int idUser, String objet, String description, String photo, String Etat, Date dateReclamation) {
        this.idUser = idUser;
        this.objet = objet;
        this.description = description;
        this.photo = photo;
        this.Etat = Etat;
        this.dateReclamation = dateReclamation;
    }

    public Reclamation() {
       
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }



    @Override
    public String toString() {
        return "Reclamation{" + "id=" + idUser + ", objet=" + objet + ", description=" + description + ", photo=" + photo + ", Etat=" + Etat + ", dateReclamation=" + dateReclamation + '}';
    }

  

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public String getObjet() {
        return objet;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public String getEtat() {
        return Etat;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

}
