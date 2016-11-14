
import entity.Abonne;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();

        Abonne toto = new Abonne("toto", "titi");
        
        session.save(toto);

        tx.commit();

        HibernateUtil.closeSession();
        HibernateUtil.getSessionFactory().close();
    }

}
