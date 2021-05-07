
package DAO;


import Tabele.Klasa;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class KlasaDao implements DAO<Klasa, String> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public KlasaDao() {
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

	public void persist(Klasa entity) {
		getCurrentSession().save(entity);
	}

	public void update(Klasa entity) {
		getCurrentSession().update(entity);
	}

	public Klasa findById(String id) {
		Klasa klasa = (Klasa) getCurrentSession().get(Klasa.class, id);
		return klasa; 
	}

	public void delete(Klasa entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Klasa> findAll() {
		List<Klasa> klasy = (List<Klasa>) getCurrentSession().createQuery("from klasy").list();
		return klasy;
	}

	public void deleteAll() {
		List<Klasa> entityList = findAll();
		for (Klasa entity : entityList) {
			delete(entity);
		}
	}
        
        @SuppressWarnings("unchecked")
        public List<Klasa> findByRocznik(int id) {
		List<Klasa> klasay = (List<Klasa>) getCurrentSession().createQuery("from klasy where id_rocznika = " + id).list();
		return klasay; 
	}

}