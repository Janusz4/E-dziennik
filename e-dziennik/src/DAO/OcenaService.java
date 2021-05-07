package DAO;

import Tabele.Ocena;
import Tabele.Uczen;
import java.util.List;

public class OcenaService {

	private static OcenaDao ocenaDao;

	public OcenaService() {
		ocenaDao = new OcenaDao();
	}

	public void persist(Ocena entity) {
		ocenaDao.openCurrentSessionwithTransaction();
		ocenaDao.persist(entity);
		ocenaDao.closeCurrentSessionwithTransaction();
	}

	public void update(Ocena entity) {
		ocenaDao.openCurrentSessionwithTransaction();
		ocenaDao.update(entity);
		ocenaDao.closeCurrentSessionwithTransaction();
	}

	public Ocena findById(String id) {
		ocenaDao.openCurrentSession();
		Ocena ocena = ocenaDao.findById(id);
		ocenaDao.closeCurrentSession();
		return ocena;
	}

	public void delete(String id) {
		ocenaDao.openCurrentSessionwithTransaction();
		Ocena ocena = ocenaDao.findById(id);
		ocenaDao.delete(ocena);
		ocenaDao.closeCurrentSessionwithTransaction();
	}
        
        public void delete(Ocena ocena) {
		ocenaDao.openCurrentSessionwithTransaction();
		ocenaDao.delete(ocena);
		ocenaDao.closeCurrentSessionwithTransaction();
	}

	public List<Ocena> findAll() {
		ocenaDao.openCurrentSession();
		List<Ocena> oceny = ocenaDao.findAll();
		ocenaDao.closeCurrentSession();
		return oceny;
	}

	public void deleteAll() {
		ocenaDao.openCurrentSessionwithTransaction();
		ocenaDao.deleteAll();
		ocenaDao.closeCurrentSessionwithTransaction();
	}

	public OcenaDao ocenaDao() {
		return ocenaDao;
	}
        
        public List<Ocena> findByUczenPrzedmiot(int idU, int idP) {
		ocenaDao.openCurrentSession();
		List<Ocena> oceny = ocenaDao.findByUczenPrzedmiot(idU, idP);
		ocenaDao.closeCurrentSession();
		return oceny;
	}


}
