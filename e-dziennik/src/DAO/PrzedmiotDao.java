
package DAO;


import Tabele.Przedmiot;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class PrzedmiotDao implements DAO<Przedmiot, String> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public PrzedmiotDao() {
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

	public void persist(Przedmiot entity) {
		getCurrentSession().save(entity);
	}

	public void update(Przedmiot entity) {
		getCurrentSession().update(entity);
	}

	public Przedmiot findById(String id) {
		Przedmiot przedmiot = (Przedmiot) getCurrentSession().get(Przedmiot.class, id);
		return przedmiot; 
	}

	public void delete(Przedmiot entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Przedmiot> findAll() {
		List<Przedmiot> przedmioty = (List<Przedmiot>) getCurrentSession().createQuery("from przedmioty").list();
		return przedmioty;
	}

	public void deleteAll() {
		List<Przedmiot> entityList = findAll();
		for (Przedmiot entity : entityList) {
			delete(entity);
		}
	}

}