
package com.pidev.IService;

import java.sql.SQLException;
import java.util.List;
import com.pidev.Entite.Reclamation;

public interface IServiceReclamation<R> {

    void ajouter(R r) throws SQLException;

    boolean delete(R r) throws SQLException;

    boolean update(String objet, String description, String photo , String Etat, Reclamation r) throws SQLException;

    List<R> readAll() throws SQLException;
    
    R rechercher(int a) throws SQLException;
}
