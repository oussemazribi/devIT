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
public class votes {
    private User id_user;
    private int id_publication;
    private Date date;
    private int valeur;
    
    public votes(User id_user,int id_publication,Date date,int valeur)
    {
        this.id_user=id_user;
        this.id_publication=id_publication;
        this.date=date;
        this.valeur=valeur;
    }
      public votes(User id_user,int id_publication,int valeur)
    {
        this.id_user=id_user;
        this.id_publication=id_publication;
        this.valeur=valeur;
    }

    public votes() {
       
    }
    
     public void setiduser(User iduser)
    {
        this.id_user=iduser;
        
    }  
    public User getiduser()
    {
        return id_user;
    }
    public void setidpublication(int id_publication)
    {
        this.id_publication=id_publication;
    }
    public int getidpublication()
    {
        return id_publication;
    }
    public void setdate(Date date)
    {
        this.date=date;
    }
    public Date getdate()
    {
        return date;
    }
    public void setvaleur(int valeur)
    {
        this.valeur=valeur;
    }
    public int getvaleur()
    {
        return valeur;
    }
    
    @Override
    public String toString()
    {
          return "Vote{" + "Identifiant d'Auteur=" + id_user+ ", Identifiant de Publication =" + id_publication + ",Valeur=" + valeur +",Date de crÃ©ation="+date+'}';
    }
}
