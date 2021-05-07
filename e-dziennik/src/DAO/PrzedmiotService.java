package DAO;

import Tabele.Przedmiot;
import java.util.List;

public class PrzedmiotService {

	private static PrzedmiotDao przedmiotDao;

	public PrzedmiotService() {
		przedmiotDao = new PrzedmiotDao();
	}

	public void persist(Przedmiot entity) {
		przedmiotDao.openCurrentSessionwithTransaction();
		przedmiotDao.persist(entity);
		przedmiotDao.closeCurrentSessionwithTransaction();
	}

	public void update(Przedmiot entity) {
		przedmiotDao.openCurrentSessionwithTransaction();
		przedmiotDao.update(entity);
		przedmiotDao.closeCurrentSessionwithTransaction();
	}

	public Przedmiot findById(String id) {
		przedmiotDao.openCurrentSession();
		Przedmiot przedmiot = przedmiotDao.findById(id);
		przedmiotDao.closeCurrentSession();
		return przedmiot;
	}

	public void delete(String id) {
		przedmiotDao.openCurrentSessionwithTransaction();
		Przedmiot przedmiot = przedmiotDao.findById(id);
		przedmiotDao.delete(przedmiot);
		przedmiotDao.closeCurrentSessionwithTransaction();
	}
        
        public void delete(Przedmiot przedmiot) {
		przedmiotDao.openCurrentSessionwithTransaction();
		przedmiotDao.delete(przedmiot);
		przedmiotDao.closeCurrentSessionwithTransaction();
	}

	public List<Przedmiot> findAll() {
		przedmiotDao.openCurrentSession();
		List<Przedmiot> uczniowie = przedmiotDao.findAll();
		przedmiotDao.closeCurrentSession();
		return uczniowie;
	}

	public void deleteAll() {
		przedmiotDao.openCurrentSessionwithTransaction();
		przedmiotDao.deleteAll();
		przedmiotDao.closeCurrentSessionwithTransaction();
	}

	public PrzedmiotDao przedmiotDao() {
		return przedmiotDao;
	}
}
