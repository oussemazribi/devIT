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
public class Publicite {

    private Annonce annonce;
    private  User user;
    private Date DateDebut;
    private Date DateFin;
    private String Etat;
    private String Pack;
    private Float Prix;

    public void setPrix(Float Prix) {
        this.Prix = Prix;
    }

    public Float getPrix() {
        return Prix;
    }
    public Publicite(Annonce annonce, User user, Date DateDebut, Date DateFin, String Etat, String Pack, Float Prix) {
        this.annonce = annonce;
        this.user = user;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Etat = Etat;
        this.Pack = Pack;
        this.Prix = Prix;
    }


    public Publicite(Annonce annonce, User user, Date DateDebut, Date DateFin, String Etat, String Pack) {
        this.annonce = annonce;
        this.user = user;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Etat = Etat;
        this.Pack = Pack;
    }

    public Publicite(Annonce annonce, Date DateDebut, Date DateFin, String Etat, String Pack) {
        this.annonce = annonce;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Etat = Etat;
        this.Pack = Pack;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public User getUser() {
        return user;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public String getEtat() {
        return Etat;
    }

    public String getPack() {
        return Pack;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDateDebut(Date DateDebut) {
        this.DateDebut = DateDebut;
    }

    public void setDateFin(Date DateFin) {
        this.DateFin = DateFin;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public void setPack(String Pack) {
        this.Pack = Pack;
    }

    @Override
    public String toString() {
        return "Publicite{" + "annonce=" + annonce + ", user=" + user + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", Etat=" + Etat + ", Pack=" + Pack + '}';
    }
    




}
