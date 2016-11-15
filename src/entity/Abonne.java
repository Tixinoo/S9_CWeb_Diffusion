package entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * Représente un abonné
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 */
public class Abonne {

    protected String login;
    protected String mdp;
    protected Set<Message> messagesEnvoyes = new HashSet<>();

    public Abonne() {
    }

    public Abonne(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

    public boolean exists() {
        Session session = HibernateUtil.currentSession();

        List<Abonne> abonnes = session.createQuery("FROM Abonne WHERE login='" + this.login + "' AND mdp='" + this.mdp + "'").list();
        return !abonnes.isEmpty();
    }

    /**
     * Persistence de l'abonné avec Hibernate
     */
    public void save() {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();

        session.save(this);
        tx.commit();
    }

    public void addMessageEnvoye(Message message) {
        this.messagesEnvoyes.add(message);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.login);
        hash = 67 * hash + Objects.hashCode(this.mdp);
        hash = 67 * hash + Objects.hashCode(this.messagesEnvoyes);
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
        final Abonne other = (Abonne) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.mdp, other.mdp)) {
            return false;
        }
        if (!Objects.equals(this.messagesEnvoyes, other.messagesEnvoyes)) {
            return false;
        }
        return true;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Set<Message> getMessagesEnvoyes() {
        return messagesEnvoyes;
    }

    public void setMessagesEnvoyes(Set<Message> messagesEnvoyes) {
        this.messagesEnvoyes = messagesEnvoyes;
    }

    @Override
    public String toString() {
        return "Abonne{" + "login=" + login + ", mdp=" + mdp + ", messagesEnvoyes={" + this.printMessagesEnvoyes() + "}";
    }

    private String printMessagesEnvoyes() {
        String res = "";
        Iterator<Message> iterator = this.messagesEnvoyes.iterator();
        while (iterator.hasNext()) {
            Message m = iterator.next();
            res = res + "" + m.toString();
        }
        return res;
    }

}
