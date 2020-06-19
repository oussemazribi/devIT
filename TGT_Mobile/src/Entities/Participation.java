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
public class Participation {
    
    int compet ; 
    int user;
    int idparticipation;

    public int getCompet() {
        return compet;
    }

    public void setCompet(int compet) {
        this.compet = compet;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getIdparticipation() {
        return idparticipation;
    }

    public void setIdparticipation(int idparticipation) {
        this.idparticipation = idparticipation;
    }

    public Participation() {
    }

    @Override
    public String toString() {
        return "Participation{" + "compet=" + compet + ", user=" + user + ", idparticipation=" + idparticipation + '}';
    }

    public Participation(int compet, int user) {
        this.compet = compet;
        this.user = user;
    }

    public Participation(int compet, int user, int idparticipation) {
        this.compet = compet;
        this.user = user;
        this.idparticipation = idparticipation;
    }
    
    

    
    
}
