
package com.pidev.IService;


import java.sql.SQLException;
import java.util.List;
import com.pidev.Entite.Annonce;


public interface IServiceAnnonce<T> {
    void ajouter(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
    boolean update(String Nom,String Description,int Prix,String Etat ,int idAnnonce) throws SQLException;
    List<T> readAll() throws SQLException;
}

