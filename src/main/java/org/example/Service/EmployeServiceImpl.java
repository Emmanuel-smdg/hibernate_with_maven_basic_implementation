package org.example.Service;

import org.example.config.HibernateUtil;
import org.example.entities.Employe;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeServiceImpl implements EmployeService{

    private Session session;
    private Transaction transaction;

    public EmployeServiceImpl() {
        this.session = HibernateUtil.getSessionFactory().openSession();;
    }

    /**
     * @param employe
     * @return
     */
    public Employe Save(Employe employe) {
        transaction = session.beginTransaction();
        //session.save(employe);
        session.persist(employe);
        transaction.commit();;
        return employe ;
    }

    /**
     * @param id
     * @return
     */
    public Employe findById(String id) {
        return session.get(Employe.class, id);
    }

    /**
     * @param employe
     * @return
     */
    public Employe Update(Employe employe) {
        transaction = session.beginTransaction();
        session.merge(employe);
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
        session.remove(session.get(Employe.class, id));
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
