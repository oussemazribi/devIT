/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungottalent.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tungottalent.Entite.Annonce;
import tungottalent.Entite.CommentaireAnnonce;
import tungottalent.Entite.User;
import tungottalent.IService.IServiceCommentaireAnnonce;
import tungottalent.Utils.DataBase;

/**
 *
 * @author ousse
 */
public class ServiceCommentaireAnnonce implements IServiceCommentaireAnnonce<CommentaireAnnonce> {

    private Connection con;
    private Statement ste;

    public ServiceCommentaireAnnonce() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(CommentaireAnnonce t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`commentaireannonce` (`idCommentaire`,`idUser`, `idAnnonce`, `contenue`, `date`) VALUES (NULL, '" + t.getUser().getIdUser()+ "','" + t.getAnnonce().getIdAnnonce() + "','" + t.getContenue() + "','" + t.getDate() + "');";
        ste.executeUpdate(requeteInsert);
    }

    /* public void ajouter1(Personne p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `esprit1`.`personne` ( `nom`, `prenom`, `age`) VALUES ( ?, ?, ?);");
        pre.setString(1, p.getNom());
        pre.setString(2, p.getPrenom());
        pre.setInt(3, p.getAge());
        pre.executeUpdate();
    }
     */
    @Override
    public boolean delete(CommentaireAnnonce t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottalent`.`commentaireannonce` where idCommentaire =?");
        pre.setInt(1, t.getIdCommentaire());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
        return true;
    }

    @Override
    public boolean update( String Contenue,CommentaireAnnonce c) throws SQLException {
        String sql = "UPDATE commentaireannonce SET idUser=?, idAnnonce=?, contenue=? , date=? WHERE idCommentaire=?";

        PreparedStatement statement = con.prepareStatement(sql);

        statement.setString(3, Contenue);
        statement.setInt(5,c.getIdCommentaire());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
        return true;
    }

    @Override
    public List<CommentaireAnnonce> readAll() throws SQLException {
        List<CommentaireAnnonce> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from commentaireannonce");
        while (rs.next()) {
            int IdCommentaire = rs.getInt(1);
            int IdUser = rs.getInt(2);
            int IdAnnonce = rs.getInt(3);
            String Contenue = rs.getString(4);
            String Date = rs.getString(5);
            CommentaireAnnonce c = new CommentaireAnnonce(IdCommentaire,User.class.cast(IdUser),Annonce.class.cast(IdAnnonce),Contenue,Date);
            arr.add(c);
        }
        return arr;
    }

}
