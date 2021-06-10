package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Cv;

@RestController
@RequestMapping(value = "/api/cv")
@CrossOrigin
public class CvsController {
	private CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAll() {
		return this.cvService.getAll();
	}

	@PostMapping("/addCv")
	public Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}

	@PostMapping("/getByCvIdForJobSeeker_UserId")
	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(@RequestParam int userId) {
		return this.cvService.getByCvIdForJobSeeker_UserId(userId);
	}
}
