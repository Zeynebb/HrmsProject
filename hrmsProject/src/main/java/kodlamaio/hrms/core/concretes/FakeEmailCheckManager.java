package kodlamaio.hrms.core.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import kodlamaio.hrms.core.abstracts.EmailCheckService;

@Component
@Primary
public class FakeEmailCheckManager implements EmailCheckService{

	@Override
	public boolean emailCheck(String email) {
		return true;		
	}

}
