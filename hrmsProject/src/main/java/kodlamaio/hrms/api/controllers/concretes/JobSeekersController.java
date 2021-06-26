package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.ValidationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("api/jobSeekers")
@CrossOrigin
public class JobSeekersController {

	private JobSeekerService jobSeekerService;
	private ValidationService validationService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService, ValidationService validationService) {
		super();
		this.jobSeekerService = jobSeekerService;
		this.validationService = validationService;
	}

	@GetMapping("/getAll")
	public DataResult<List<JobSeeker>> getAll() {
		return this.jobSeekerService.getAll();
	}
	@GetMapping("/getJobSeekerByUserId")
	public DataResult<JobSeeker> getJobSeekerByUserId(int userId){
		return this.jobSeekerService.getJobSeekerByUserId(userId);
	}

	@PostMapping("/register")
	public Result register(@Valid @RequestBody JobSeeker jobSeeker, @RequestParam("passwordAgain") String passwordAgain,
			@RequestParam("validationCode") long validationCode) {
		return this.jobSeekerService.register(jobSeeker, passwordAgain,validationCode);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		return this.validationService.handleValidationException(exceptions);
	}
}
