/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.IService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author asus
 * @param <Publication>
 * @param <Commentaire>
 * @param <Vote>
 * @param <Reaction>
 
 */
public interface ISERPub<Publication,Commentaire,Vote,Reaction> {
    public Map<Publication,Commentaire> readcomments() throws SQLException;
    public Map<Publication,Vote > showvotes() throws SQLException;
    public Map<Publication,Reaction > showreaction() throws SQLException;
    List<Publication> mostvoted() throws SQLException;
    List<Publication> mostreacted() throws SQLException;
    List<Commentaire> commentofpost(int id) throws SQLException;
    public int countkol() throws SQLException;
    
    
    
    
    
}
