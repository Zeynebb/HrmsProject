package kodlamaio.hrms.core.concretes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import kodlamaio.hrms.core.abstracts.ValidationService;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;

@Service
public class ValidationManager implements ValidationService{

	@Override
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErros = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErros.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErros, 
				"Doğrulama Hataları");
		return errors;
	}

}
