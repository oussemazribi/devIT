/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author loume78
 */
public class fos_user {
    
    int id;
    String username;
    String username_canonical;
    String email;
    String email_canonical;
    int enabled;
    String password;
    String roles;
    String typecompte;
    String typetalent;
    String prenom;
    int numtel;
    String imguser;
    int nbdiament;

    public fos_user(int id, String username, String username_canonical, String email, String email_canonical, int enabled, String password, String roles, String typecompte, String typetalent, String prenom, int numtel, String imguser, int nbdiament) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.password = password;
        this.roles = roles;
        this.typecompte = typecompte;
        this.typetalent = typetalent;
        this.prenom = prenom;
        this.numtel = numtel;
        this.imguser = imguser;
        this.nbdiament = nbdiament;
    }

    public fos_user(String username, String username_canonical, String email, String email_canonical, int enabled, String password, String roles, String typecompte, String typetalent, String prenom, int numtel, String imguser, int nbdiament) {
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.password = password;
        this.roles = roles;
        this.typecompte = typecompte;
        this.typetalent = typetalent;
        this.prenom = prenom;
        this.numtel = numtel;
        this.imguser = imguser;
        this.nbdiament = nbdiament;
    }

    public fos_user() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getTypecompte() {
        return typecompte;
    }

    public void setTypecompte(String typecompte) {
        this.typecompte = typecompte;
    }

    public String getTypetalent() {
        return typetalent;
    }

    public void setTypetalent(String typetalent) {
        this.typetalent = typetalent;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getImguser() {
        return imguser;
    }

    public void setImguser(String imguser) {
        this.imguser = imguser;
    }

    public int getNbdiament() {
        return nbdiament;
    }

    public void setNbdiament(int nbdiament) {
        this.nbdiament = nbdiament;
    }

    @Override
    public String toString() {
        return "fos_user{" + "id=" + id + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", enabled=" + enabled + ", password=" + password + ", roles=" + roles + ", typecompte=" + typecompte + ", typetalent=" + typetalent + ", prenom=" + prenom + ", numtel=" + numtel + ", imguser=" + imguser + ", nbdiament=" + nbdiament + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}
