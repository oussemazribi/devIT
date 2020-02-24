/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Entite;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Image;
import java.util.Date;
import com.pidev.Service.ServiceUser ;

/**
 *
 * @author HPENV
 */
public class User {
    

    private int idUser;
    private String Nom;
    private String Prenom;
    private String Email;
    private String Login;
    private String MotDePasse;
    private String Sexe;
    private String DateNaissance;
    private int NumTelephone;
    private String TypeCompte;
    private String TypeTalent;
    private String Imguser;
    private int NbDiament;
    
    public User (){
                
    }

    public User(String Nom, String Prenom) {
        this.Nom = Nom;
        this.Prenom = Prenom;
    }
    
    
    public User(String Nom, String Prenom, String Email, String Login, String MotDePasse, String Sexe, String DateNaissance, int NumTelephone, String TypeCompte, String TypeTalent, String Imguser, int NbDiament) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Login = Login;
        this.MotDePasse = MotDePasse;
        this.Sexe = Sexe;
        this.DateNaissance = DateNaissance;
        this.NumTelephone = NumTelephone;
        this.TypeCompte = TypeCompte;
        this.TypeTalent = TypeTalent;
        this.Imguser = Imguser;
        this.NbDiament = 0;
    }

    public User(int idUser, String Nom, String Prenom, String Email, String Login, String MotDePasse, String Sexe, String DateNaissance, int NumTelephone, String TypeCompte, String TypeTalent, String Imguser, int NbDiament) {
        this.idUser = idUser;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Login = Login;
        this.MotDePasse = MotDePasse;
        this.Sexe = Sexe;
        this.DateNaissance = DateNaissance;
        this.NumTelephone = NumTelephone;
        this.TypeCompte = TypeCompte;
        this.TypeTalent = TypeTalent;
        this.Imguser = Imguser;
        this.NbDiament = 0;
    }

    public int getNbDiament() {
        return NbDiament;
    }

    public void setNbDiament(int NbDiament) {
        this.NbDiament = NbDiament;
    }
    
    

    public User(String Nom, String Prenom, String Email, String Login, String MotDePasse, String Sexe, String DateNaissance, int NumTelephone, String TypeCompte, String TypeTalent, String Imguser) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Login = Login;
        this.MotDePasse = MotDePasse;
        this.Sexe = Sexe;
        this.DateNaissance = DateNaissance;
        this.NumTelephone = NumTelephone;
        this.TypeCompte = TypeCompte;
        this.TypeTalent = TypeTalent;
        this.Imguser = Imguser;
    }

    public User(int idUser, String Nom, String Prenom, String Email, String Login, String MotDePasse, String Sexe, String DateNaissance,
            int NumTelephone, String TypeCompte, String TypeTalent, String Imguser) {
        this.idUser = idUser;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Login = Login;
        this.MotDePasse = MotDePasse;
        this.Sexe = Sexe;
        this.DateNaissance = DateNaissance;
        this.NumTelephone = NumTelephone;
        this.TypeCompte = TypeCompte;
        this.TypeTalent = TypeTalent;
        this.Imguser = Imguser;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Email=" + Email + ", Login=" + Login + ", MotDePasse=" + MotDePasse + ", Sexe=" + Sexe + ", DateNaissance=" + DateNaissance + ", NumTelephone=" + NumTelephone + ", TypeCompte=" + TypeCompte + ", TypeTalent=" + TypeTalent + ", Imguser=" + Imguser + ", NbDiament=" + NbDiament + '}';
    }

    

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setMotDePasse(String MotDePasse) {
        this.MotDePasse = MotDePasse;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public void setDateNaissance(String DateNaissance) {
        this.DateNaissance = DateNaissance;
    }

    public void setNumTelephone(int NumTelephone) {
        this.NumTelephone = NumTelephone;
    }

    public void setTypeCompte(String TypeCompte) {
        this.TypeCompte = TypeCompte;
    }

    public void setTypeTalent(String TypeTalent) {
        this.TypeTalent = TypeTalent;
    }

    public void setImguser(String Imguser) {
        this.Imguser = Imguser;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getEmail() {
        return Email;
    }

    public String getLogin() {
        return Login;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public String getSexe() {
        return Sexe;
    }

    public String getDateNaissance() {
        return DateNaissance;
    }

    public int getNumTelephone() {
        return NumTelephone;
    }

    public String getTypeCompte() {
        return TypeCompte;
    }

    public String getTypeTalent() {
        return TypeTalent;
    }

    public String getImguser() {
        return Imguser;
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

//    
//    public int getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(int idUser) {
//        this.idUser = idUser;
//    }
//
//    public String getNom() {
//        return Nom;
//    }
//
//    public void setNom(int nom) {
//        this.Nom = Nom;
//
//    }
//
//    public String getPrenom() {
//        return Prenom;
//    }
//
//    public void setPrenom(String Prenom) {
//        this.Prenom = Prenom;
//    }
//
//    public String getEmail() {
//        return Email;
//    }
//
//    public void setEmail(String Email) {
//        this.Email = Email;
//    }
//
//    public String getLogin() {
//        return Login;
//    }
//
//    public void setLogin(String Login) {
//        this.Login = Login;
//    }
//
//    public String getMotDePasse() {
//        return MotDePasse;
//    }
//
//    public void setMotDePasse(String MotDePasse) {
//        this.MotDePasse = MotDePasse;
//    }
//
//    public String getSexe() {
//        return Sexe;
//    }
//
//    public void setSexe(String Sexe) {
//        this.Sexe = Sexe;
//    }
//
//    public String getDateNaissance() {
//        return DateNaissance;
//    }
//
//    public void setDateNaissance(String DateNaissance) {
//        this.DateNaissance = DateNaissance;
//    }
//
//    public int NumTelephone() {
//        return NumTelephone;
//    }
//
//    public void setNumTelephone(int idNumTelephone) {
//        this.NumTelephone = NumTelephone;
//    }
//
//    public String getTypeCompte() {
//        return TypeCompte;
//    }
//
//    public void setTypeCompte(String TypeCompte) {
//        this.TypeCompte = TypeCompte;
//    }
//
//    public String getTypeTalent() {
//        return TypeTalent;
//    }
//
//    public void setTypeTalent(String TypeTalent) {
//        this.TypeTalent = TypeTalent;
//    }
//
//    public String getImguser() {
//        return Imguser;
//    }
//
//    public void setImguser(String Imguser) {
//        this.Imguser = Imguser;
//    }
//}
