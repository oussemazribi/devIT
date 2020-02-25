/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Entite;

import java.util.Date;

/**
 *
 * @author ousse
 */
public class CommentaireAnnonce {

    private int IdCommentaire;
    private User user;
    private Annonce  annonce;
    private String Contenue;
    private String Date;

    public CommentaireAnnonce(User user, Annonce annonce, String Contenue, String Date) {
        this.user = user;
        this.annonce = annonce;
        this.Contenue = Contenue;
        this.Date = Date;
    }

    public CommentaireAnnonce(int IdCommentaire, User user, Annonce annonce, String Contenue, String Date) {
        this.IdCommentaire = IdCommentaire;
        this.user = user;
        this.annonce = annonce;
        this.Contenue = Contenue;
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "CommentaireAnnonce{" + "IdCommentaire=" + IdCommentaire + ", user=" + user + ", annonce=" + annonce + ", Contenue=" + Contenue + ", Date=" + Date + '}';
    }

    public void setIdCommentaire(int IdCommentaire) {
        this.IdCommentaire = IdCommentaire;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public void setContenue(String Contenue) {
        this.Contenue = Contenue;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getIdCommentaire() {
        return IdCommentaire;
    }

    public User getUser() {
        return user;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public String getContenue() {
        return Contenue;
    }

    public String getDate() {
        return Date;
    }


}
