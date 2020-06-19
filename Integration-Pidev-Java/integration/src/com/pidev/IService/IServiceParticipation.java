/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.IService;


import com.pidev.Entite.Competition;
import com.pidev.Entite.Participation;
import com.pidev.Entite.User;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author loume78
 */
public interface IServiceParticipation<T> {
    
    void ajouter(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
    boolean update(int idCompetition, Participation p) throws SQLException;
   // public Map<User,Competition> readAll() throws SQLException;
    
}
