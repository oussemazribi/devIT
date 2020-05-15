/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TGT.myapp.entities;

import java.util.Date;

/**
 *
 * @author HPENVY
 */
public class Blog {
    private int  id ;
    private String  sujet ;
    private String conteu ;

    public Blog() {
    }
    private Date dateCreation ;
    private String photo;

    public Blog(int id, String sujet, String conteu, Date dateCreation, String photo) {
        this.id = id;
        this.sujet = sujet;
        this.conteu = conteu;
        this.dateCreation = dateCreation;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getConteu() {
        return conteu;
    }

    public void setConteu(String conteu) {
        this.conteu = conteu;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getPhoto() {
        return photo;
    }

    public Blog(String sujet, String conteu, Date dateCreation) {
        this.sujet = sujet;
        this.conteu = conteu;
        this.dateCreation = dateCreation;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", sujet=" + sujet + ", conteu=" + conteu + ", dateCreation=" + dateCreation + ", photo=" + photo + '}';
    }
    
    
    
}
