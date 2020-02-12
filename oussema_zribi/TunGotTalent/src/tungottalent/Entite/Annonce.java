
package tungottalent.Entite;


public class Annonce {
    private int idAnnonce;
    private int idUser;
    private String Nom;
    private String Description ;
    private double Prix;
    private String Etat;
    
    
    public Annonce(int idAnnonce, int idUser , String Nom, String Description, double Prix, String Etat) {
        this.idAnnonce = idAnnonce;
        this.idUser = idUser;
        this.Nom = Nom;
        this.Description = Description;
        this.Prix = Prix;
        this.Etat = Etat;
    }

    public Annonce(int idUser, String Nom, String Description, double Prix, String Etat) {
        this.idUser = idUser;
        this.Nom = Nom;
        this.Description = Description;
        this.Prix = Prix;
        this.Etat = Etat;
    }

    @Override
    public String toString() {
        return "Annonce{" + "idAnnonce=" + idAnnonce + ", idUser=" + idUser + ", Nom=" + Nom + ", Description=" + Description + ", Prix=" + Prix + ", Etat=" + Etat + '}';
    }

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPrix(double Prix) {
        this.Prix = Prix;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getNom() {
        return Nom;
    }

    public String getDescription() {
        return Description;
    }

    public double getPrix() {
        return Prix;
    }

    public String getEtat() {
        return Etat;
    }

    

  }
