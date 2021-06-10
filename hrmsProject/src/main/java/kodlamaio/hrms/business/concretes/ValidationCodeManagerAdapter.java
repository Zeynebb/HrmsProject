package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ValidationCodeService;
import kodlamaio.hrms.validationCodeService.ValidationCodeManager;

@Service
public class ValidationCodeManagerAdapter implements ValidationCodeService {

	private ValidationCodeManager validationCodeManager;
	
	@Autowired
	public ValidationCodeManagerAdapter(ValidationCodeManager validationCodeManager) {
		super();
		this.validationCodeManager = validationCodeManager;
	}

	@Override
	public long codeCreate() {
		return this.validationCodeManager.createCode();
	}

}
