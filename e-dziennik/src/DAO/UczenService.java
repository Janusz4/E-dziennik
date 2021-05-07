package DAO;

import Tabele.Uczen;
import java.util.List;

public class UczenService {

	private static UczenDao uczenDao;

	public UczenService() {
		uczenDao = new UczenDao();
	}

	public void persist(Uczen entity) {
		uczenDao.openCurrentSessionwithTransaction();
		uczenDao.persist(entity);
		uczenDao.closeCurrentSessionwithTransaction();
	}

	public void update(Uczen entity) {
		uczenDao.openCurrentSessionwithTransaction();
		uczenDao.update(entity);
		uczenDao.closeCurrentSessionwithTransaction();
	}

	public Uczen findById(String id) {
		uczenDao.openCurrentSession();
		Uczen uczen = uczenDao.findById(id);
		uczenDao.closeCurrentSession();
		return uczen;
	}

	public void delete(String id) {
		uczenDao.openCurrentSessionwithTransaction();
		Uczen uczen = uczenDao.findById(id);
		uczenDao.delete(uczen);
		uczenDao.closeCurrentSessionwithTransaction();
	}
        
        public void delete(Uczen uczen) {
		uczenDao.openCurrentSessionwithTransaction();
		uczenDao.delete(uczen);
		uczenDao.closeCurrentSessionwithTransaction();
	}

	public List<Uczen> findAll() {
		uczenDao.openCurrentSession();
		List<Uczen> uczniowie = uczenDao.findAll();
		uczenDao.closeCurrentSession();
		return uczniowie;
	}

	public void deleteAll() {
		uczenDao.openCurrentSessionwithTransaction();
		uczenDao.deleteAll();
		uczenDao.closeCurrentSessionwithTransaction();
	}

	public UczenDao uczenDao() {
		return uczenDao;
	}
        
        public List<Uczen> findByKlasa(int id) {
		uczenDao.openCurrentSession();
		List<Uczen> uczniowie = uczenDao.findByKlasa(id);
		uczenDao.closeCurrentSession();
		return uczniowie;
	}
        
        public List<Uczen> findByRocznik(int id) {
		uczenDao.openCurrentSession();
		List<Uczen> uczniowie = uczenDao.findByRocznik(id);
		uczenDao.closeCurrentSession();
		return uczniowie;
	}

}
