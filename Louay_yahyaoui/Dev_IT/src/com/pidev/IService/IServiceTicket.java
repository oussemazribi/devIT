/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.IService;
import com.pidev.Entite.Competition;
import com.pidev.Entite.Ticket;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author loume78
 */
public interface IServiceTicket<T> {
    
    void ajouter(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
    List<T> readAll() throws SQLException;
    public Ticket findById(int idTicket) throws SQLException;
     
    
}
