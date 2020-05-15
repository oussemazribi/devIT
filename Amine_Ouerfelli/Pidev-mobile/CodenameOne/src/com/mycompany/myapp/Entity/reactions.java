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
public class reactions {
    private int id_user;
    private int id_publication;
    private Date date;
    private int type;
    
    public reactions(int id_user,int id_publication,Date date,int type)
    {
        this.id_user=id_user;
        this.id_publication=id_publication;
        this.date=date;
        this.type=type;
    }
       public reactions(int id_user,int id_publication,int type)
    {
        this.id_user=id_user;
        this.id_publication=id_publication;
     
        this.type=type;
    }


     public void setiduser(int iduser)
    {
        this.id_user=iduser;
        
    }  
    public int getiduser()
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
    public void settype(int type)
    {
        this.type=type;
    }
    public int gettype()
    {
        return type;
    }
    
    @Override
    public String toString()
    {
          return "Reaction{" + "Identifiant d'Auteur=" + id_user+ ", Identifiant de Publication =" + id_publication + ",Type=" + type +",Date de crÃ©ation="+date+'}';
    }
    
    
}
