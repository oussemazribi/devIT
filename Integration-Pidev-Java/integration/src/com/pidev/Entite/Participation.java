/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Entite;

import java.util.Objects;

/**
 *
 * @author loume78
 */
public class Participation {
    
   Competition compet ; 
   User user;
    

    public Participation(Competition compet, User user) {
        this.compet = compet;
        this.user = user;
        
    }

    public Participation(User user) {
        this.user = user;
        
    }

  

    public Competition getCompetition() {
        return compet;
    }

    public User getUser() {
        return user;
    }

    

    public void setCompetition(Competition compet ) {
        this.compet = compet;
    }

    public void setIdUser(User user) {
        this.user = user;
    }

    

    

    @Override
    public String toString() {
        return "Participation{" + "idCompetition=" + compet + ", idUser=" + user + '}';
    }

    
    
    
    
}
