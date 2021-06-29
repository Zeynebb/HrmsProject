package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Personnel;

@RestController
@RequestMapping("/api/personnel")
@CrossOrigin
public class PersonnelsController {

	private PersonnelService personnelService;

	@Autowired
	public PersonnelsController(PersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}

	@GetMapping("/getAll")
	public List<Personnel> getAll() {
		return this.personnelService.getAll();
	}

	@PostMapping("/register")
	public Result register(@RequestBody Personnel personnel) {
		return this.personnelService.register(personnel);
	}
	@GetMapping("/getByUserId")
	public DataResult<Personnel> getByUserId(int userId){
		return this.personnelService.getByUserId(userId);
	}

	@Transactional
	@PostMapping("/employerVerification")
	public Result updateEmployerSetVerificationStatusForUserId(@RequestParam("employerId") int employerId,
			@RequestParam("status") boolean status) {
		return this.personnelService.updateEmployerSetVerificationStatusForUserId(employerId, status);
	}

}
