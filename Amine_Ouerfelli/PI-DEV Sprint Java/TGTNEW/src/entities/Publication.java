/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Publication {
    private int id;
    private int id_auteur;
    private Date date;
    private String type;
    private String contenu;
    private int visibilite;
    private String description;
    private int nb_vote;
    private int nb_comm;
    private int nb_react;
     

    

    public Publication(int id,int id_auteur,Date date,String type,String contenu,int visibilite,String description) {
        this.id = id;
        this.id_auteur = id_auteur;
        this.date = date;
        this.type = type;
        this.contenu=contenu;
        this.visibilite=visibilite;
        this.description=description;
    }
    public Publication()
    {
    }
     public Publication(int id_auteur,String type,String contenu,int visibilite,String description) {
        this.id_auteur = id_auteur;
        this.type = type;
        this.contenu=contenu;
        this.visibilite=visibilite;
        this.description=description;
    }
    public Publication(int id,int id_auteur,Date date,String type,String contenu,int visibilite,String description,int nbcomm,int nbreac,int nbv) {
        this.id=id;
        this.id_auteur = id_auteur;
        this.date = date;
        this.type = type;
        this.contenu=contenu;
        this.visibilite=visibilite;
        this.description=description;
        this.nb_comm=nbcomm;
        this.nb_react=nbreac;
        this.nb_vote=nbv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   public int getId_auteur() {
        return id_auteur;
    }

    public void setId_auteur(int id_auteur) {
        this.id_auteur = id_auteur;
    }
    
    public Date getdate() {
        return date;
    }

    public void setdate(Date date) {
        this.date = date;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String getcontenu() {
        return contenu ;
    }

    public void setcontenu(String contenu) {
        this.contenu = contenu;
    }

    public int getvisibilite()
    { 
        return visibilite;
    }
    public void setvisibilite(int visibilite)
    {
        this.visibilite=visibilite;
    }
    public String getdescription()
    {
        return description;
    }
    public void setdescription(String description)
    {
        this.description=description;
    }
    @Override
    public String toString() {
        return "Publication{" + "Identifiant =" + id + ", Identifiant d'Auteur=" + id_auteur+ ", Date =" + date + ", Type=" + type +",Contenu="+contenu+",Visibilité="+visibilite+",Description="+description+ '}';
    }
    
}
