/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceservice;

import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author asus
 * @param <T>
 */
public interface IServices<T> {
  
    void ajouter(T t) throws SQLException;
    boolean supprimer(T t) throws SQLException;
    boolean modifier(T t) throws SQLException;
    List<T> readAll() throws SQLException;
    T rechercher(int a) throws SQLException;
    List<T> readAllsorted() throws SQLException;
    List<T> showpublicationbyuser(int a)throws SQLException;
    int calculatereacts(int a)throws SQLException;
    int calculateups(int a)throws SQLException;
    int calculatedowns(int a)throws SQLException;
    List<T> showcommentsbypub(int a)throws SQLException;

    

    
}
