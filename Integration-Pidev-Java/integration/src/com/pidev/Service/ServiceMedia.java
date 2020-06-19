/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Service;

import com.pidev.Entite.Medias;
import com.pidev.IService.IServices;
import com.pidev.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ServiceMedia implements IServices<Medias> {
      private Connection con;
    private Statement ste;

    public ServiceMedia() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public List<Medias> readAll() throws SQLException {
    List<Medias> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from media");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String type=rs.getString(2);
               String source=rs.getString(3);
               String description=rs.getString(4);
               String mediatype=rs.getString(5);
               int idPost=rs.getInt(6);
               int idUser=rs.getInt(7);
               System.out.println(source);
               Medias m=new Medias(id,type,source,mediatype,idUser,idPost,description);
     arr.add(m);
     }
    return arr;
    }


    @Override
    public List<Medias> showMediabypost(int a) throws SQLException {
    List<Medias> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet res=ste.executeQuery("select * from media where idPost='"+a+"';");
    System.out.println("m");
    while (res.next()) {    
       
               int id=res.getInt(1);
               String type=res.getString(2);
               String source=res.getString(3);
               String description=res.getString(4);
               String mediatype=res.getString(5);
               int idPost=res.getInt(6);
               int idUser=res.getInt(7);
               
               Medias m=new Medias(id,type,source,mediatype,idUser,idPost,description);
               
     arr.add(m);
     }
    return arr;
    }

    @Override
    public void ajouter(Medias m) throws SQLException {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `tunisiangottalent`.`media` (`id`, `idPost`, `idUser`, `mediatype`,`source`,`type`,'description) VALUES (?,?,?,?,?,?,?);");
    pre.setInt(1, m.getId());
    pre.setInt(2, m.getIdpub());
    pre.setInt(3,m.getIduser());
    pre.setString(4,m.getMediatype());
    pre.setString(5,m.getSource());
    pre.setString(5,m.getType());
    pre.setString(7,m.getDescription());
    pre.executeUpdate();
    }

    @Override
    public boolean supprimer(Medias t) throws SQLException {
   PreparedStatement pre=con.prepareStatement("DELETE FROM `tunisiangottalent`.`commentaire` where idUser= ? and idPost= ? and id=?");
    pre.setInt(1,t.getIduser());
    pre.setInt(2, t.getIdpub());
    pre.setInt(3,t.getId());
    pre.executeUpdate();
    int rowDeleted=pre.executeUpdate();
    if(rowDeleted>0)
    {
        System.out.println("a media has been deleted");
    }
    return true;
    }

    @Override
    public boolean modifier(Medias t) throws SQLException {
        String sql = "UPDATE `tunisiangottalent`.`commentaire` SET source=?, mediatype=?,type=? WHERE idPost=? and id= ?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1,t.getSource());
        statement.setString(2,t.getMediatype());
        statement.setInt(3,t.getIdpub());
        statement.setInt(4, t.getId());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing comment was updated successfully!");
        }
        return true;
    }

    @Override
    public Medias rechercher(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medias> readAllsorted() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medias> showpublicationbyuser(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculatereacts(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculateups(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculatedowns(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medias> showcommentsbypub(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
