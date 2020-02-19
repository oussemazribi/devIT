package tungottalent.Service;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import tungottalent.Entite.Annonce;
import tungottalent.Entite.User;
import tungottalent.Utils.DataBase;
import tungottalent.IService.IServiceAnnonce;

public class ServiceAnnonce implements IServiceAnnonce<Annonce> {

    private Connection con;
    private Statement ste;

    public ServiceAnnonce() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Annonce t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`annonce` (`idAnnonce`, `idUser`, `Nom`, `Description`,`Prix`,`Etat`,`images`) VALUES (NULL, '" + t.getUser().getIdUser() + "', '" + t.getNom() + "','" + t.getDescription() + "','" + t.getPrix() + "','" + t.getEtat() + "','" + t.getImages().toString() + "');";
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
    public boolean delete(Annonce t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `tunisiangottalent`.`annonce` where Nom =?");
        pre.setString(1, t.getNom());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
        return true;
    }

    @Override
    public boolean update(String Nom, String Description, int Prix, String Etat, int idAnnonce) throws SQLException {
        String sql = "UPDATE annonce SET Nom=?, Description=?, Prix=? , Etat=? WHERE Nom=?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, Nom);
        statement.setString(2, Description);
        statement.setDouble(3, Prix);
        statement.setString(4, Etat);
        statement.setInt(5, idAnnonce);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
        return true;
    }

    @Override
    public List<Annonce> readAll() throws SQLException {
        List<Annonce> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from annonce");
        while (rs.next()) {
            int idAnnonce = rs.getInt(1);
            int idUser = rs.getInt(2);
            String Nom = rs.getString(3);
            String Description = rs.getString(4);
            double Prix = rs.getDouble(5);
            String Etat = rs.getString(6);
            ServiceUser service = new ServiceUser();
            User user = service.findById(idUser);
            Annonce p = new Annonce(idAnnonce, user, Nom, Description, Prix, Etat);
            arr.add(p);
        }
        return arr;
    }

    public Annonce findById(int idAnnonce) throws SQLException {
        String req = "select * from annonce where idAnnonce = ?";
        Annonce annonce = null;
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, idAnnonce);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int idUser = resultSet.getInt(2);
                ServiceUser ser = new ServiceUser();
                User u = ser.findById(idUser);

                annonce = new Annonce(idAnnonce, u, resultSet.getString(3), resultSet.getString(4), resultSet.getDouble(5), resultSet.getString(6));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return annonce;
    }

}
