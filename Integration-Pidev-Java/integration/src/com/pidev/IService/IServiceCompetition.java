/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.IService;
import com.pidev.Entite.Competition;
import com.pidev.Entite.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author loume78
 */
public interface IServiceCompetition<T> {
    
    void ajouter(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
    boolean update(String Titre, String Description,String TypeDeTalent,String DateDebut,String DateFin, int Cout,String ImageC,  String titre) throws SQLException;
     public List<Competition> readAll1() throws SQLException;
    public Competition findByComp(Competition c) throws SQLException;
    public List<Competition> findByTalent(String Talents) throws SQLException;
    
    
    
}
