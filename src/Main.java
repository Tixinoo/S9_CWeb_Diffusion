
import entity.Abonne;
import entity.Annuaire;
import entity.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();

        Annuaire blagueurs = new Annuaire("blagueurs");
        Abonne toto = new Abonne("toto", "titi");
        Message blague = new Message("bonne blague", "toto, as-tu pris une douche ce matin ?");
        
        session.save(blagueurs);
        session.save(toto);
        session.save(blague);

        tx.commit();

        HibernateUtil.closeSession();
        HibernateUtil.getSessionFactory().close();
    }

}
