/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Entity;

import com.codename1.io.Externalizable;
import com.codename1.io.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Achrafoun
 */
public class Publication implements Serializable,Externalizable {

    private Integer id;
    private String contenu;
    private Date datePublication;
    private User idUser;
    private String titre;
    private Integer nb_comments;
    private Integer nb_reacts;
    private Integer nb_votes;
    ArrayList<Medias> mediapost;
    ArrayList<Commentaire>  Commentaires;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getNb_comments() {
        return nb_comments;
    }

    public void setNb_comments(Integer nb_comments) {
        this.nb_comments = nb_comments;
    }

    public Integer getNb_reacts() {
        return nb_reacts;
    }

    public void setNb_reacts(Integer nb_reacts) {
        this.nb_reacts = nb_reacts;
    }

    public Integer getNb_votes() {
        return nb_votes;
    }

    public void setNb_votes(Integer nb_votes) {
        this.nb_votes = nb_votes;
    }

    public ArrayList<Commentaire> getCommentaires() {
        return Commentaires;
    }

    public void setCommentaires(ArrayList<Commentaire> Commentaires) {
        this.Commentaires = Commentaires;
    }

    public Publication() {
      mediapost=new ArrayList();
      Commentaires=new ArrayList();
    }

    public ArrayList<Medias> getMediapost() {
        return mediapost;
    }

    public void setMediapost(ArrayList<Medias> mediapost) {
        this.mediapost = mediapost;
    }

    public Publication(String contenu, User idUser) {
        this.contenu = contenu;
        this.idUser = idUser;
    }
    
    public Publication(String contenu, Date datePublication, User idUser) {
        this.contenu = contenu;
        this.datePublication = datePublication;
        this.idUser = idUser;
    }

    public Publication(Integer id, String contenu, Date datePublication, User idUser,String titre,Integer nb_comments,Integer nb_votes,Integer nb_reacts) {
        this.id = id;
        this.contenu = contenu;
        this.datePublication = datePublication;
        this.idUser = idUser;
        this.nb_comments=nb_comments;
        this.nb_reacts=nb_reacts;
        this.nb_votes=nb_votes;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public String gettitre() {
        return titre;
    }

    public void settitre(String titre) {
        this.titre = titre;
    }

    public void setnbreacts(Integer nb_reacts) {
        this.nb_reacts = nb_reacts;
    }
    public Integer getnb_reacts() {
        return nb_reacts;
    }

    public void setnbvotes(Integer nb_votes) {
        this.nb_votes = nb_votes;
    }
    public Integer getnbvotes() {
        return nb_votes;
    }

    public void setnbcomments(Integer nb_comments) {
        this.nb_comments = nb_comments;
    }
    public Integer getnbcomments()
    {
        return nb_comments;
    }
    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publication)) {
            return false;
        }
        Publication other = (Publication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", contenu=" + contenu + ", datePublication=" + datePublication + ", idUser=" + idUser +",nombre des reactions="+nb_reacts+",nombre des commentaires="+nb_comments+",nombre des votes="+nb_votes+ '}';
    }
    
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public void externalize(DataOutputStream out) throws IOException {
        Util.writeObject(id, out);
;
    }

    @Override
    public void internalize(int version, DataInputStream in) throws IOException {
        id = (Integer) Util.readObject(in);
         
    }

    @Override
    public String getObjectId() {
      return "Post"; 
    }
    public static Publication createPost(Map<String,Object> mappedpost)
    {
        Publication post = new Publication();
        post.setId((int)Float.parseFloat(mappedpost.get("id").toString()));
        return post;
    }
    

    
}
