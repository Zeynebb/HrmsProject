package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Technology;

@RestController
@RequestMapping("/api/technology")
public class TechnologiesController {
	
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Technology>> getAll(){
		return this.technologyService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Technology technology) {
		return this.technologyService.add(technology);
	}

}
