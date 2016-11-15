package entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 */
public class Annuaire {

    private String nomAnnuaire;
    private Set<Abonne> abonnes = new HashSet<>();

    public Annuaire(String nom) {
        this.nomAnnuaire = nom;
    }

    public void addAbonne(Abonne abonne) {
        this.abonnes.add(abonne);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nomAnnuaire);
        hash = 67 * hash + Objects.hashCode(this.abonnes);
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
        if (!Objects.equals(this.nomAnnuaire, other.nomAnnuaire)) {
            return false;
        }
        if (!Objects.equals(this.abonnes, other.abonnes)) {
            return false;
        }
        return true;
    }

    public String getNomAnnuaire() {
        return nomAnnuaire;
    }

    public void setNomAnnuaire(String nomAnnuaire) {
        this.nomAnnuaire = nomAnnuaire;
    }

    public Set<Abonne> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(Set<Abonne> abonnes) {
        this.abonnes = abonnes;
    }

    @Override
    public String toString() {
        return "Annuaire{" + "nomAnnuaire=" + nomAnnuaire + ", abonnes=" + abonnes + '}';
    }
    
}
