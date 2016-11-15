
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
        
        Entreprise raymond = new Entreprise("Bibal & Cie", "raymond", "XB2212");
        session.save(raymond);
        
        Particulier marie = new Particulier("Rouana", "Marie", "marie1u", "XB2213");
        session.save(marie);
        
        blagueurs.addAbonne(raymond);
        blagueurs.addAbonne(marie);
        
        Message blague = new Message("bonne blague", "toto, as-tu pris une douche ce matin ?");
        session.save(blague);
        
        blague.setExpediteur(raymond);

        tx.commit();

        HibernateUtil.closeSession();
        HibernateUtil.getSessionFactory().close();
    }

}
