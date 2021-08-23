package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;

public interface EmailSendService {
	
	public void fakeEmailSend(String email, long verificationCode);
	
	public Result sendEmail( String email, long verificationCode) throws Exception;

}
