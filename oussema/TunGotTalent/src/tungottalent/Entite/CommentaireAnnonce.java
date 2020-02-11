/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungottalent.Entite;

import java.util.Date;

/**
 *
 * @author ousse
 */
public class CommentaireAnnonce {

    private int IdCommentaire;
    private int IdUser;
    private int IdAnnonce;
    private String Contenue;
    private String Date;

    public void setIdCommentaire(int IdCommentaire) {
        this.IdCommentaire = IdCommentaire;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public void setIdAnnonce(int IdAnnonce) {
        this.IdAnnonce = IdAnnonce;
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

    public int getIdUser() {
        return IdUser;
    }

    public int getIdAnnonce() {
        return IdAnnonce;
    }

    public String getContenue() {
        return Contenue;
    }

    public String getDate() {
        return Date;
    }

    public CommentaireAnnonce(int IdCommentaire, int IdUser, int IdAnnonce, String Contenue, String Date) {
        this.IdCommentaire = IdCommentaire;
        this.IdUser = IdUser;
        this.IdAnnonce = IdAnnonce;
        this.Contenue = Contenue;
        this.Date = Date;
    }

    public CommentaireAnnonce(int IdUser, int IdAnnonce, String Contenue, String Date) {
        this.IdUser = IdUser;
        this.IdAnnonce = IdAnnonce;
        this.Contenue = Contenue;
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "CommentaireAnnonce{" + "IdCommentaire=" + IdCommentaire + ", IdUser=" + IdUser + ", IdAnnonce=" + IdAnnonce + ", Contenue=" + Contenue + ", Date=" + Date + '}';
    }

}
