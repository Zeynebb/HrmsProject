package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	public Result register(JobSeeker jobSeeker, String passwordAgain, long validationCode);
	
	public Result emailVerification(JobSeeker jobSeeker, String passwordAgain, long validationCode) throws Exception ;
	
	public Result emailSending(String email) throws Exception ;
	
	public boolean emailIsItUsed(String email);
	
	public boolean nationalityIdIsItUsed(String nationalityId);
	
	public DataResult<List<JobSeeker>> getAll();
	public List<String> getAllEmails();
	public List<String> getAllNationalityId();
	
	public DataResult<JobSeeker>  getJobSeekerByUserId(int userId);

}
