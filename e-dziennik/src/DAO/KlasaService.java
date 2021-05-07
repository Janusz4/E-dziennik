package DAO;

import Tabele.Klasa;
import java.util.List;

public class KlasaService {

	private static KlasaDao klasaDao;

	public KlasaService() {
		klasaDao = new KlasaDao();
	}

	public void persist(Klasa entity) {
		klasaDao.openCurrentSessionwithTransaction();
		klasaDao.persist(entity);
		klasaDao.closeCurrentSessionwithTransaction();
	}

	public void update(Klasa entity) {
		klasaDao.openCurrentSessionwithTransaction();
		klasaDao.update(entity);
		klasaDao.closeCurrentSessionwithTransaction();
	}

	public Klasa findById(String id) {
		klasaDao.openCurrentSession();
		Klasa klasa = klasaDao.findById(id);
		klasaDao.closeCurrentSession();
		return klasa;
	}

	public void delete(String id) {
		klasaDao.openCurrentSessionwithTransaction();
		Klasa klasa = klasaDao.findById(id);
		klasaDao.delete(klasa);
		klasaDao.closeCurrentSessionwithTransaction();
	}
        
        public void delete(Klasa klasa) {
		klasaDao.openCurrentSessionwithTransaction();
		klasaDao.delete(klasa);
		klasaDao.closeCurrentSessionwithTransaction();
	}

	public List<Klasa> findAll() {
		klasaDao.openCurrentSession();
		List<Klasa> klasy = klasaDao.findAll();
		klasaDao.closeCurrentSession();
		return klasy;
	}

	public void deleteAll() {
		klasaDao.openCurrentSessionwithTransaction();
		klasaDao.deleteAll();
		klasaDao.closeCurrentSessionwithTransaction();
	}

	public KlasaDao klasaDao() {
		return klasaDao;
	}
        
        public List<Klasa> findByRocznik(int id) {
		klasaDao.openCurrentSession();
		List<Klasa> klasy = klasaDao.findByRocznik(id);
		klasaDao.closeCurrentSession();
		return klasy;
	}
}
