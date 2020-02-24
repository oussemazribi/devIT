/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.IService;

import java.sql.SQLException;
import java.util.List;
import com.pidev.Entite.CommentaireAnnonce;

/**
 *
 * @author ousse
 */
public interface IServiceCommentaireAnnonce<T> {

    void ajouter(T t) throws SQLException;

    boolean delete(T t) throws SQLException;

    boolean update(String Contenue, CommentaireAnnonce c) throws SQLException;

    List<T> readAll() throws SQLException;

}
