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
    
    int idCompetition ; 
    int idUser ;
    

    public Participation(int idCompetition, int idUser) {
        this.idCompetition = idCompetition;
        this.idUser = idUser;
        
    }

    public Participation(int idUser) {
        this.idUser = idUser;
        
    }

  

    public int getIdCompetition() {
        return idCompetition;
    }

    public int getIdUser() {
        return idUser;
    }

    

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participation other = (Participation) obj;
        if (this.idCompetition != other.idCompetition) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        
        
        return true;
    }

    @Override
    public String toString() {
        return "Participation{" + "idCompetition=" + idCompetition + ", idUser=" + idUser + '}';
    }

    
    
    
    
}
