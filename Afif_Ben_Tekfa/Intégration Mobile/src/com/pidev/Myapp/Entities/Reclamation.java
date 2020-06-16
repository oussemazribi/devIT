/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Myapp.Entities;

import java.util.Date;

/**
 *
 * @author BENTEKFA
 */
public class Reclamation {
    private int id;
    private String objet, description, photo, etat;
    private Date dateReclamation;

public Reclamation (){
    
}    
    public Reclamation(int id, String objet, String description, String photo, String etat, Date dateReclamation) {
        this.id = id;
        this.objet = objet;
        this.description = description;
        this.photo = photo;
        this.etat = etat;
        this.dateReclamation = dateReclamation;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", objet=" + objet + ", description=" + description + ", photo=" + photo + ", etat=" + etat + ", dateReclamation=" + dateReclamation + '}';
    }
}
