package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.ValidationService;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	
	private EmployerService employerService;
	private ValidationService validationService;

	@Autowired
	public EmployersController(EmployerService employerService,ValidationService validationService) {
		super();
		this.employerService = employerService;
		this.validationService=validationService;
	}
	
	
	@GetMapping("/getAll")
	public List<Employer> getAll() {
		return this.employerService.getAll();
	}
	
	@PostMapping("/resigter")
	public ResponseEntity<?> register(@Valid @RequestBody Employer employer , String passwordAgain ) {
		return ResponseEntity.ok(this.employerService.register(employer, passwordAgain));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		return this.validationService.handleValidationException(exceptions);
	}

}
