
import entity.Abonne;
import entity.Annuaire;
import entity.Entreprise;
import entity.Message;
import entity.Particulier;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();

        Annuaire blagueurs = new Annuaire("blagueurs");
        session.save(blagueurs);
        
        Entreprise bibal = new Entreprise("Bibal");
        Particulier raymond = new Particulier("pointcarre", "raymond");
        session.save(bibal);
        session.save(raymond);
        
        Message blague = new Message("bonne blague", "toto, as-tu pris une douche ce matin ?");
        session.save(blague);
        
        Abonne toto = new Abonne("toto", "titi");
        session.save(toto);
        
        blague.setExpediteur(toto);

        tx.commit();

        HibernateUtil.closeSession();
        HibernateUtil.getSessionFactory().close();
    }

}
