package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Personnel;


public interface PersonnelService {
	
	public List<Personnel> getAll();
	
	public Result register(Personnel personnel);

}
