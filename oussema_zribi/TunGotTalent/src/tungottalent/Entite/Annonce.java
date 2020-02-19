
package tungottalent.Entite;


public class Annonce {
    private int idAnnonce;
    private User user;
    private String Nom;
    private String Description ;
    private double Prix;
    private String Etat;

    public Annonce(User user, String Nom, String Description, double Prix, String Etat) {
        this.user = user;
        this.Nom = Nom;
        this.Description = Description;
        this.Prix = Prix;
        this.Etat = Etat;
    }

    public Annonce(int idAnnonce, User user, String Nom, String Description, double Prix, String Etat) {
        this.idAnnonce = idAnnonce;
        this.user = user;
        this.Nom = Nom;
        this.Description = Description;
        this.Prix = Prix;
        this.Etat = Etat;
    }

    
    
    @Override
    public String toString() {
        return "Annonce{" + "idAnnonce=" + idAnnonce + ", user=" + user + ", Nom=" + Nom + ", Description=" + Description + ", Prix=" + Prix + ", Etat=" + Etat + '}';
    }

    
    public int getIdAnnonce() {
        return idAnnonce;
    }

    public User getUser() {
        return user;
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

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public void setUser(User user) {
        this.user = user;
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
    
    
    

  }
