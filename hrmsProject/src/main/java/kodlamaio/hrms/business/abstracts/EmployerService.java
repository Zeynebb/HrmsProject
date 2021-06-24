package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	public Result register(Employer employer, String passwordAgain);
	
	public Result login( String email, String password);
	
	public DataResult<Employer>  getByUserId(int userId);
	
	public DataResult<List<Employer>> getAllEmployerByVerificationStatus(boolean status);
	
	public List<Employer> getAll();
	public List<String> getAllEmails();
	
	
	


}
