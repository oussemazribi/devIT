/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Entity;

import java.util.Date;

/**
 *
 * @author HPENVY
 */
public class Comment {
    private int id ;
    private int Blog_id ;
    private String contenu ;
    private Date dateCreation ;
    private int id_user ;
    private Blog b;

    public Blog getB() {
        return b;
    }

    public void setB(Blog b) {
        this.b = b;
    }

    public Comment() {
    }

    public Comment(int id, int Blog_id, String contenu, Date dateCreation, int id_user) {
        this.id = id;
        this.Blog_id = Blog_id;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlog_id() {
        return Blog_id;
    }

    public void setBlog_id(int Blog_id) {
        this.Blog_id = Blog_id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", Blog_id=" + Blog_id + ", contenu=" + contenu + ", dateCreation=" + dateCreation + ", id_user=" + id_user + '}';
    }
    
}
