package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Map;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	public Result register(Employer employer, String passwordAgain);
	
	public Result login( String email, String password);
	
	public Result update(Employer employer);
	
	public DataResult<Employer>  getByUserId(int userId);
	
	public DataResult<List<Employer>> getAllEmployerByVerificationStatus(boolean status);
	
	public List<Employer> getAll();
	public List<String> getAllEmails();
	
	public DataResult<Map<String, Object>> getUpdateByUserId(int userId);
	
	public Result updatedEmployerVerification(int employerId);
	
	public DataResult<List<Employer>> getAllUpdatedEmployer();


}
