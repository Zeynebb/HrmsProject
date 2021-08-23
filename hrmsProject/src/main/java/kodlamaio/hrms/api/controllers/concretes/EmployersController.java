package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.ValidationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {

	private EmployerService employerService;
	private ValidationService validationService;

	@Autowired
	public EmployersController(EmployerService employerService, ValidationService validationService) {
		super();
		this.employerService = employerService;
		this.validationService = validationService;
	}

	@GetMapping("/getAll")
	public List<Employer> getAll() {
		return this.employerService.getAll();
	}

	@PostMapping("/login")
	public Result login(@RequestParam("email") String email, @RequestParam("password") String password) {
		return this.employerService.login(email, password);
	}

	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employerService.update(employer));
	}

	@GetMapping("/getByEmployerUserId")
	public DataResult<Employer> getByUserId(int userId) {
		return this.employerService.getByUserId(userId);
	}

	@GetMapping("/getAllEmployerByVerificationStatus")
	public DataResult<List<Employer>> getAllEmployerByVerificationStatus(boolean status) {
		return this.employerService.getAllEmployerByVerificationStatus(status);
	}

	@GetMapping("/getUpdateByUserId")
	public DataResult<Map<String, Object>> getUpdateByUserId(int userId) {
		return this.employerService.getUpdateByUserId(userId);
	}

	@PostMapping("/updatedEmployerVerification")
	public Result updatedEmployerVerification(int employerId) {
		return this.employerService.updatedEmployerVerification(employerId);
	}

	@GetMapping("/getAllUpdatedEmployer")
	public DataResult<List<Employer>> getAllUpdatedEmployer() {
		return this.employerService.getAllUpdatedEmployer();
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody Employer employer,
			@RequestParam("passwordAgain") String passwordAgain, @RequestParam("validationCode") long validationCode) {
		return ResponseEntity.ok(this.employerService.register(employer, passwordAgain, validationCode));
	}
	@PostMapping("/emailSending")
	public Result emailSending(String email, String website) throws Exception{
		return this.employerService.emailSending(email, website);
	}
	@GetMapping("/emailIsItUsed")
	public boolean emailIsItUsed(String email) {
		return this.employerService.emailIsItUsed(email);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		return this.validationService.handleValidationException(exceptions);
	}

}
