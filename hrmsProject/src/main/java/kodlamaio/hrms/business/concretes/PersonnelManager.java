package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PersonnelDao;
import kodlamaio.hrms.entities.concretes.Personnel;

@Service
public class PersonnelManager implements PersonnelService{
	
	private PersonnelDao personnelDao;
	
	@Autowired
	public PersonnelManager(PersonnelDao personnelDao) {
		super();
		this.personnelDao = personnelDao;
	}
	@Override
	public List<Personnel> getAll() {
		return this.personnelDao.findAll();
	}
	@Override
	public Result register(Personnel personnel) {
		this.personnelDao.save(personnel);
		return new SuccessResult("Personel Eklendi.");
	}

}
