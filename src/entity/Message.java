package entity;

import java.util.List;
import java.util.Objects;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 */
public class Message {

    private int idMessage;
    private String objet;
    private String corps;
    private Abonne expediteur;

    public Message() {}
    
    public Message(String objet, String corps) {
        this.objet = objet;
        this.corps = corps;
    }

    /*public void save() {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        session.save(this);
        tx.commit();
    }
    
    public static List<Message> getAll() {
        Session session = HibernateUtil.currentSession();
        List<Message> l = session.createQuery("FROM Message").list(); 
        return l;
    }*/
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idMessage;
        hash = 67 * hash + Objects.hashCode(this.objet);
        hash = 67 * hash + Objects.hashCode(this.corps);
        hash = 67 * hash + Objects.hashCode(this.expediteur);
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
        final Message other = (Message) obj;
        if (this.idMessage != other.idMessage) {
            return false;
        }
        if (!Objects.equals(this.objet, other.objet)) {
            return false;
        }
        if (!Objects.equals(this.corps, other.corps)) {
            return false;
        }
        if (!Objects.equals(this.expediteur, other.expediteur)) {
            return false;
        }
        return true;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public Abonne getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Abonne expediteur) {
        this.expediteur = expediteur;
    }

    @Override
    public String toString() {
        return "Message{\n" + "idMessage=" + idMessage + ", \nobjet=" + objet + ", \ncorps=" + corps + "\n}";
    }

}
