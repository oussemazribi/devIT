/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Entity;

import com.codename1.io.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author HPENVY
 */
public class Blog {
    private int  id ;
    private String  sujet ;
    private String conteu ;
    ArrayList<Comment>  Commentaires;

    public ArrayList<Comment> getCommentaires() {
        return Commentaires;
    }

    public void setCommentaires(ArrayList<Comment> Commentaires) {
        this.Commentaires = Commentaires;
    }

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

    public Blog(String sujet, String conteu, Date dateCreation , String photo) {
        this.sujet = sujet;
        this.conteu = conteu;
        this.dateCreation = dateCreation;
        this.photo = photo ;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", sujet=" + sujet + ", conteu=" + conteu + ", dateCreation=" + dateCreation + ", photo=" + photo + '}';
    }
    
    public int getVersion() {
        return 1;
    }

    public void externalize(DataOutputStream out) throws IOException {
        Util.writeObject(id, out);
;
    }

    public void internalize(int version, DataInputStream in) throws IOException {
        id = (Integer) Util.readObject(in);
         
    }
      public String getObjectId() {
      return "Blog"; 
    }
     public static Blog createBlog(Map<String,Object> mappedBlog)
    {
        Blog b = new Blog();
        b.setId((int)Float.parseFloat(mappedBlog.get("id").toString()));
        return b;
    }
    
}
