/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Entity;
import java.util.Date;
/**
 *
 * @author asus
 */
public class Commentaire {
    private int id;
    private User user;
    private Publication post;
    private String contenu;
    private Date date;
    
    public Commentaire(int id,User user,Publication post,String contenu,Date date)
    {
        this.id=id;
        this.post=post;
        this.user=user;
        this.contenu=contenu;
        this.date=date;
    }

    public Commentaire() {
        
    }
    public void setid(int id)
    {
        this.id=id;
    }
    public int getid()
    {
        return id;
    }
    public void setuser(User user)
    {
        this.user=user;
        
    }  
    public User getiduser()
    {
        return user;
    }
    public void setpost(Publication post)
    {
        this.post=post;
    }
    public Publication getpost()
    {
        return post;
    }
    public void setcontenu(String contenu)
    {
        this.contenu=contenu;
    }
    public String getcontenu()
    {
        return contenu;
    }
    
    public void setdate(Date date)
    {
        this.date=date;
    }
    public Date getdate()
    {
        return date;
    }

    @Override
    public String toString()
    {
          return "Commentaire{" + "Identifiant =" + id + ", Identifiant d'Auteur=" + user.getId()+ ", Identifiant de Publication =" + post.getId() + ", Contenu=" + contenu +",Date de crÃ©ation="+date+'}';
    }
    
    
}
