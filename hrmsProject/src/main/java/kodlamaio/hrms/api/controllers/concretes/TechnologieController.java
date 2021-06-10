package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Technology;

@RestController
@RequestMapping("/api/technology")
public class TechnologieController {
	
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologieController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Technology>> getAll(){
		return this.technologyService.getAll();
	}

}
