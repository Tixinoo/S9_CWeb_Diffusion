
import entity.Abonne;
import entity.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();

        Abonne toto = new Abonne("toto", "titi");
        Message blague = new Message("Bonne blague", "Toto, as-tu pris une douche ce matin ?");
        
        session.save(toto);
        session.save(blague);

        tx.commit();

        HibernateUtil.closeSession();
        HibernateUtil.getSessionFactory().close();
    }

}
