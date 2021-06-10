package kodlamaio.hrms.core.abstracts;

import org.springframework.web.bind.MethodArgumentNotValidException;

import kodlamaio.hrms.core.utilities.result.ErrorDataResult;

public interface ValidationService {
	
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions);
	

}
