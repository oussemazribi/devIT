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
    
    Competition compet ; 
   fos_user user;

    public Participation(Competition compet, fos_user user) {
        this.compet = compet;
        this.user = user;
    }

    public Competition getCompet() {
        return compet;
    }

    public void setCompet(Competition compet) {
        this.compet = compet;
    }

    public fos_user getUser() {
        return user;
    }

    public void setUser(fos_user user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Participation{" + "compet=" + compet + ", user=" + user + '}';
    }
   
   
    
}
