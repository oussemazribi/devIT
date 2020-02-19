/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungottalent.Entite;



/**
 *
 * @author ousse
 */
public class Publicite {

    private Annonce annonce;
    private  User user;
    private String DateDebut;
    private String DateFin;
    private String Etat;
    private float Prix;

    public Publicite(Annonce annonce, User user, String DateDebut, String DateFin, String Etat, float Prix) {
        this.annonce = annonce;
        this.user = user;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Etat = Etat;
        this.Prix = Prix;
    }

    @Override
    public String toString() {
        return "Publicite{" + "annonce=" + annonce + ", user=" + user + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", Etat=" + Etat + ", Prix=" + Prix + '}';
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDateDebut(String DateDebut) {
        this.DateDebut = DateDebut;
    }

    public void setDateFin(String DateFin) {
        this.DateFin = DateFin;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public void setPrix(float Prix) {
        this.Prix = Prix;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public User getUser() {
        return user;
    }

    public String getDateDebut() {
        return DateDebut;
    }

    public String getDateFin() {
        return DateFin;
    }

    public String getEtat() {
        return Etat;
    }

    public float getPrix() {
        return Prix;
    }

    public Publicite(Annonce annonce, String DateDebut, String DateFin, String Etat, float Prix) {
        this.annonce = annonce;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Etat = Etat;
        this.Prix = Prix;
    }


}
