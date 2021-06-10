package kodlamaio.hrms.validationCodeService;

import org.springframework.stereotype.Service;

@Service
public class ValidationCodeManager {

	public long createCode() {
		long code= 100000+(int)(Math.random()* 999999);
		return code;		
	}
}
