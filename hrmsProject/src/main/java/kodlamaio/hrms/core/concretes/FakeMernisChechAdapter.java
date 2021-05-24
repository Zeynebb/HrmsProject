package kodlamaio.hrms.core.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Component
@Primary
public class FakeMernisChechAdapter implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		return true;
	}
	

}
