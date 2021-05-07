
package DAO;


import Tabele.Uczen;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UczenDao implements DAO<Uczen, String> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public UczenDao() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Uczen entity) {
		getCurrentSession().save(entity);
	}

	public void update(Uczen entity) {
		getCurrentSession().update(entity);
	}

	public Uczen findById(String id) {
		Uczen uczen = (Uczen) getCurrentSession().get(Uczen.class, id);
		return uczen; 
	}

	public void delete(Uczen entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Uczen> findAll() {
		List<Uczen> uczniowie = (List<Uczen>) getCurrentSession().createQuery("from uczniowie").list();
		return uczniowie;
	}

	public void deleteAll() {
		List<Uczen> entityList = findAll();
		for (Uczen entity : entityList) {
			delete(entity);
		}
	}
        
        @SuppressWarnings("unchecked")
	public List<Uczen> findByKlasa(int id) {
		List<Uczen> uczniowie = (List<Uczen>) getCurrentSession().createQuery(
                        "select u from uczniowie u where u.id_klasy =" + id
                ).list();
		return uczniowie;
	}
        
        @SuppressWarnings("unchecked")
	public List<Uczen> findByRocznik(int id) {
		List<Uczen> uczniowie = (List<Uczen>) getCurrentSession().createQuery(
                        "select u from uczniowie u, klasy k where u.id_klasy = k.id_klasy and k.id_rocznika = " + id
                ).list();
		return uczniowie;
	}

}