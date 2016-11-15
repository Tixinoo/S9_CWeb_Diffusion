
import entity.Annuaire;
import entity.Entreprise;
import entity.Message;
import entity.Particulier;
import java.util.List;
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
        
        Message question = new Message("Bonne blague", "Un moniteur demande à Toto : 'As-tu pris une douche ce matin ?' A ton avis, que répond Toto ?");
        session.save(question);
        question.setExpediteur(raymond);
        
        Message reponsefausse = new Message("Re:Bonne blague", "je ne sais pas ?");
        session.save(reponsefausse);
        reponsefausse.setExpediteur(marie);

        Message bonnereponse = new Message("Re:Re:Bonne blague", "Il répond : 'Pourquoi, il en manque une ?'");
        session.save(bonnereponse);
        bonnereponse.setExpediteur(raymond);
        
        tx.commit();
        
        List<Message> messagesDeRaymond = session.createQuery("FROM Message WHERE idAbonne='"+raymond.getLogin()+"'").list();
        System.out.println("----- Messages de Raymond :");
        for(Message m : messagesDeRaymond) {
            System.out.println(m);
        }
        System.out.println("-----");

        HibernateUtil.closeSession();
        HibernateUtil.getSessionFactory().close();
    }

}
