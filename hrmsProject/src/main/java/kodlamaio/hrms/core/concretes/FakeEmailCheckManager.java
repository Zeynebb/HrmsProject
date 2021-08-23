package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Component;
import kodlamaio.hrms.core.abstracts.EmailCheckService;

@Component
public class FakeEmailCheckManager implements EmailCheckService{

	@Override
	public boolean emailCheck(String email) {
		return true;		
	}

}
