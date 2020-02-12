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
public class Commentaire {
    private int id;
    private int iduser;
    private int id_publication;
    private String contenu;
    private Date date;
    
    public Commentaire(int id,int iduser,int id_publication,String contenu,Date date)
    {
        this.id=id;
        this.id_publication=id_publication;
        this.iduser=iduser;
        this.contenu=contenu;
        this.date=date;
    }
        public Commentaire(int iduser,int id_publication,String contenu,Date date)
    {
        this.id_publication=id_publication;
        this.iduser=iduser;
        this.contenu=contenu;
        this.date=date;
    }
    public void setid(int id)
    {
        this.id=id;
    }
    public int getid()
    {
        return id;
    }
    public void setiduser(int iduser)
    {
        this.iduser=iduser;
        
    }  
    public int getiduser()
    {
        return iduser;
    }
    public void setidpublication(int id_publication)
    {
        this.id_publication=id_publication;
    }
    public int getidpublication()
    {
        return id_publication;
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
          return "Commentaire{" + "Identifiant =" + id + ", Identifiant d'Auteur=" + iduser+ ", Identifiant de Publication =" + id_publication + ", Contenu=" + contenu +",Date de création="+date+'}';
    }
    
}
