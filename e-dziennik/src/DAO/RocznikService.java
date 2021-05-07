package DAO;

import Tabele.Rocznik;
import java.util.List;

public class RocznikService {

	private static RocznikDao rocznikDao;

	public RocznikService() {
		rocznikDao = new RocznikDao();
	}

	public void persist(Rocznik entity) {
		rocznikDao.openCurrentSessionwithTransaction();
		rocznikDao.persist(entity);
		rocznikDao.closeCurrentSessionwithTransaction();
	}

	public void update(Rocznik entity) {
		rocznikDao.openCurrentSessionwithTransaction();
		rocznikDao.update(entity);
		rocznikDao.closeCurrentSessionwithTransaction();
	}

	public Rocznik findById(String id) {
		rocznikDao.openCurrentSession();
		Rocznik rocznik = rocznikDao.findById(id);
		rocznikDao.closeCurrentSession();
		return rocznik;
	}

	public void delete(String id) {
		rocznikDao.openCurrentSessionwithTransaction();
		Rocznik rocznik = rocznikDao.findById(id);
		rocznikDao.delete(rocznik);
		rocznikDao.closeCurrentSessionwithTransaction();
	}
        
        public void delete(Rocznik rocznik) {
		rocznikDao.openCurrentSessionwithTransaction();
		rocznikDao.delete(rocznik);
		rocznikDao.closeCurrentSessionwithTransaction();
	}

	public List<Rocznik> findAll() {
		rocznikDao.openCurrentSession();
		List<Rocznik> roczniki = rocznikDao.findAll();
		rocznikDao.closeCurrentSession();
		return roczniki;
	}

	public void deleteAll() {
		rocznikDao.openCurrentSessionwithTransaction();
		rocznikDao.deleteAll();
		rocznikDao.closeCurrentSessionwithTransaction();
	}

	public RocznikDao rocznikDao() {
		return rocznikDao;
	}
}
