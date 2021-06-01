package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.UniversityService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.University;


@RestController
@RequestMapping("/api/university")
public class UniversityController {
	
	private UniversityService universityService;
	
	@Autowired
	public UniversityController(UniversityService universityService) {
		super();
		this.universityService = universityService;
	}

	@GetMapping("/getall")
	public DataResult<List<University>> getAll(){
		return this.universityService.getAll();
	}

}
