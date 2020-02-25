/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungottalent.IService;

import java.sql.SQLException;
import java.util.List;
import tungottalent.Entite.Publicite;

/**
 *
 * @author ousse
 * @param <P>
 */
public interface IServicePublicite <P>{
        void ajouter(P p) throws SQLException;
    boolean delete(P p) throws SQLException;
    boolean update(String DateDebut,String DateFin,String Etat,float Cout ,Publicite p) throws SQLException;
    List<P> readAll() throws SQLException;
    
}
