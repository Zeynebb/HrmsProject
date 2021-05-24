package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Personnel;


@RestController
@RequestMapping("/api/personnel")
public class PersonnelsController {
	
	private PersonnelService personnelService;
	
	@Autowired
	public PersonnelsController(PersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}

	@GetMapping("/getall")
	public List<Personnel> getAll(){
		return this.personnelService.getAll();
	}
	
	@PostMapping("/register")
	public Result register(@RequestBody Personnel personnel) {
		return this.personnelService.register(personnel);
	}

}
