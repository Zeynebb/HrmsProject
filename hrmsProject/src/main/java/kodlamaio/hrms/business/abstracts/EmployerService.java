package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	public Result register(Employer employer, String passwordAgain);
	
	public List<Employer> getAll();
	public List<String> getAllEmails();
	
	
	
	


}
