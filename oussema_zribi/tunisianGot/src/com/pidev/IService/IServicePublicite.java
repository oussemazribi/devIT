/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.IService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import com.pidev.Entite.Publicite;

/**
 *
 * @author ousse
 * @param <P>
 */
public interface IServicePublicite <P>{
        void ajouter(P p) throws SQLException;
    boolean delete(P p) throws SQLException;
    boolean update(Date DateDebut,Date DateFin,String Etat,String Pack,Publicite p) throws SQLException;
    List<P> readAll() throws SQLException;
    
}
