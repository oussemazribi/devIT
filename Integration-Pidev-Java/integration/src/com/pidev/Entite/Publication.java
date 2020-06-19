/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Entite;

import java.sql.Date;

public class Publication {
    private int id;
    private int id_auteur;
    private Date date;
    private String type;
    private String contenu;
    private String titre;
    private int nb_vote;
    private int nb_comm;
    private int nb_react;
     

    

    public Publication(int id,int id_auteur,Date date,String type,String contenu,String titre) {
        this.id = id;
        this.id_auteur = id_auteur;
        this.date = date;
        this.type = type;
        this.contenu=contenu;
        this.titre=titre;
    }
    public Publication()
    {
    }
     public Publication(int id_auteur,String type,String contenu,String titre,int nbcomm,int nbreac,int nbv) {
        this.id_auteur = id_auteur;
        this.type = type;
        this.contenu=contenu;
        this.titre=titre;
        this.nb_comm=nbcomm;
        this.nb_react=nbreac;
        this.nb_vote=nbv;
    }

    public int getNb_vote() {
        return nb_vote;
    }

    public void setNb_vote(int nb_vote) {
        this.nb_vote = nb_vote;
    }

    public int getNb_comm() {
        return nb_comm;
    }

    public void setNb_comm(int nb_comm) {
        this.nb_comm = nb_comm;
    }

    public int getNb_react() {
        return nb_react;
    }

    public void setNb_react(int nb_react) {
        this.nb_react = nb_react;
    }
    public Publication(int id,int id_auteur,Date date,String type,String contenu,String titre,int nbcomm,int nbreac,int nbv) {
        this.id=id;
        this.id_auteur = id_auteur;
        this.date = date;
        this.type = type;
        this.contenu=contenu;
        this.titre=titre;
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

    public String gettitre()
    {
        return titre;
    }
    public void settitre(String titre)
    {
        this.titre=titre;
    }
    @Override
    public String toString() {
        return "Publication{" + "Identifiant =" + id + ", Identifiant d'Auteur=" + id_auteur+ ", Date =" + date + ", Type=" + type +",Contenu="+contenu+",titre="+titre+ '}';
    }
    
}
