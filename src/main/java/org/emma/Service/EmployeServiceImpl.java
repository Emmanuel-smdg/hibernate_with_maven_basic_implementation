package org.emma.Service;

import org.emma.config.HibernateUtil;
import org.emma.entities.Employe;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeServiceImpl implements EmployeService{

    private Session session;
    private Transaction transaction;

    public EmployeServiceImpl() {
        this.session = HibernateUtil.getSessionFactory().openSession();;
    }

    /*
    Quelques oérations de persistance : (em = entity manager qui est connecté a ma bd et attaché au bean Employe)
    em.persist qui permet de persister un objet en bd.
    em.delete qui permet de supprimer un objet en bd.
    em.detach qui permet de détacher un bean (ici employe) avec l'entité manager.
    em.merge qui permet de ratacher le bean au em.
    em.refresh permet de recupérer les données d'un objet en bases afin de rafraichir un objet détaché dans notre code
        java (Imaginons qu'apres un detach l'objet en bd est modifié par une autre instance de em, le merge deviendra
        immpossible à moins d'utiliser refresh).
     */

    /**
     * @param employe
     * @return
     */
    public Employe Save(Employe employe) {
        transaction = session.beginTransaction();
        //session.save(employe); //Avant d'etre persiste l'employe était dans un état New
        session.persist(employe); // Ici l'employe passe a un Managed indiquant qu'il est géré par un entity manager
        transaction.commit();;
        return employe ;
    }

    /**
     * @param id
     * @return
     */
    public Employe findById(String id) {
        return session.find(Employe.class, id);
    }

    /**
     * @param employe
     * @return
     */
    public Employe Update(Employe employe) {
        transaction = session.beginTransaction();
        // Le bean est dans un état detach qui indique que c'est une représentation d'une donnée en BD.
        session.merge(employe); // Permet de rataché le bean a l'EM si l'hypothèse optimiste est vérifié sinon nous devons utilisé un refresh avant.
        transaction.commit();
        return employe;
    }

    /**
     * @param id
     * @return
     */
    public void Delete(String id) {
        transaction = session.beginTransaction();
        //session.delete(session.get(Employe.class, id));
        session.remove(session.find(Employe.class, id)); // Le bean passe a l'état removed
        transaction.commit();
    }

    /**
     * @return
     */

    @SuppressWarnings("unchecked")
    public List<Employe> findAll() {
        return (List<Employe>) session.createSelectionQuery("select employe from Employe employe").getResultList();
    }
}
