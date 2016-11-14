package entity;

import java.util.Objects;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 */
public class Annuaire {

    private String nomAnnuaire;

    public Annuaire(String nom) {
        this.nomAnnuaire = nom;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.nomAnnuaire);
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
        final Annuaire other = (Annuaire) obj;
        return Objects.equals(this.nomAnnuaire, other.nomAnnuaire);
    }

    public String getNomAnnuaire() {
        return nomAnnuaire;
    }

    public void setNomAnnuaire(String nomAnnuaire) {
        this.nomAnnuaire = nomAnnuaire;
    }
    
}
