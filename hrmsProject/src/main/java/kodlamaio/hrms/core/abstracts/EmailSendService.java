package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;

public interface EmailSendService {
	
	public void emailSend(String email);
	
	public Result run( String email) throws Exception;

}
