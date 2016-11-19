package entity;

import java.util.Objects;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 */
public class Entreprise extends Abonne {

    private String raisonSociale;

    public Entreprise() {}
    
    public Entreprise(String raisonSociale, String login, String mdp) {
        super(login, mdp);
        this.raisonSociale = raisonSociale;
    }

    public String getType() {
        return "Entreprise";
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.raisonSociale);
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
        final Entreprise other = (Entreprise) obj;
        return Objects.equals(this.raisonSociale, other.raisonSociale);
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }
    
}
