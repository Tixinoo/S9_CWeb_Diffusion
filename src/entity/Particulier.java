package entity;

import java.util.Objects;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 */
public class Particulier extends Abonne {

    private int idParticulier;
    private String nom;
    private String prenom;

    public Particulier(String nom, String prenom, String login, String mdp) {
        super(login, mdp);
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idParticulier;
        hash = 17 * hash + Objects.hashCode(this.nom);
        hash = 17 * hash + Objects.hashCode(this.prenom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Particulier other = (Particulier) obj;
        if (this.idParticulier != other.idParticulier) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        return true;
    }

    public int getIdParticulier() {
        return idParticulier;
    }

    public void setIdParticulier(int idParticulier) {
        this.idParticulier = idParticulier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Message{" + "idMessage=" + idParticulier + ", objet=" + nom + ", corps=" + prenom + '}';
    }

}
