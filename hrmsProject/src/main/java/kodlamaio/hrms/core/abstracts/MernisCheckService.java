package kodlamaio.hrms.core.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public interface MernisCheckService {	
	public boolean checkIfRealPerson(JobSeeker jobSeeker);

}
