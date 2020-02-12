/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.IService;
import com.esprit.Entite.Conversation;
import com.esprit.Entite.Message;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface IServiceC<C> {
    void ajouter(C c) throws SQLException;
//    boolean deleteC(int id_Conversation) throws SQLException;
    boolean update(String nom,int id_Me,int idU_Friend, int idConversation) throws SQLException;
    public boolean deleteAd(int idConversation )  throws SQLException ;
  //  List<C> readAll() throws SQLException;
    public Map<Conversation, Message> readMessage() throws SQLException;
}
