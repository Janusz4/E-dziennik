
package DAO;


import Tabele.Ocena;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OcenaDao implements DAO<Ocena, String> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public OcenaDao() {
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

	public void persist(Ocena entity) {
		getCurrentSession().save(entity);
	}

	public void update(Ocena entity) {
		getCurrentSession().update(entity);
	}

	public Ocena findById(String id) {
		Ocena ocena = (Ocena) getCurrentSession().get(Ocena.class, id);
		return ocena; 
	}

	public void delete(Ocena entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Ocena> findAll() {
		List<Ocena> oceny = (List<Ocena>) getCurrentSession().createQuery("from oceny").list();
		return oceny;
	}

	public void deleteAll() {
		List<Ocena> entityList = findAll();
		for (Ocena entity : entityList) {
			delete(entity);
		}
	}
        
        @SuppressWarnings("unchecked")
	public List<Ocena> findByUczenPrzedmiot(int idU, int idP) {
		List<Ocena> oceny = (List<Ocena>) getCurrentSession().createQuery(
                        "from oceny where id_ucznia = " + idU + " and id_przedmiotu = " + idP
                ).list();
		return oceny;
	}


}