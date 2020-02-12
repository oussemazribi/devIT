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

    private int idAnnonce;
    private int idUser;
    private String DateDebut;
    private String DateFin;
    private String Etat;
    private float Prix;

    public Publicite(int idAnnonce, int idUser, String DateDebut, String DateFin, String Etat, float Prix) {
        this.idAnnonce = idAnnonce;
        this.idUser = idUser;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Etat = Etat;
        this.Prix = Prix;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    @Override
    public String toString() {
        return "Publicite{" + "idAnnonce=" + idAnnonce + ", idUser=" + idUser + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", Etat=" + Etat + ", Prix=" + Prix + '}';
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public void setCout(float Prix) {
        this.Prix = Prix;
    }

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public int getIdUser() {
        return idUser;
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

}
