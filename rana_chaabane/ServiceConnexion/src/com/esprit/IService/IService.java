/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.IService;


import com.esprit.Entite.Message;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author House
 * @param <T>
 */
public interface IService<T> {
    void ajouter(T t) throws SQLException;
    boolean delete(int id_Message) throws SQLException;
   boolean transfer(int id_Message ,int id_Conversation ) throws SQLException;
     public boolean SeenMessage(int id_Message ,String etat ) throws SQLException ;
    List<T> readAll() throws SQLException;
}

