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
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvWithJobSeekerDto;

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
	@Transactional
	@PostMapping("/delete")
	public Result deleteByCvId(int cvId) {
		return this.cvService.delete(cvId);
	}
	
	@Transactional
	@PostMapping("/deleteObjective")
	public Result deleteCvSetObjective(int cvId) {
		return this.cvService.deleteCvSetObjective(cvId);
	}
	
	@GetMapping("/getCvWithJobSeekerDetails")
	public DataResult<List<CvWithJobSeekerDto>> getCvWithJobSeekerDetails(int cvId){
		return this.cvService.getCvWithJobSeekerDetails(cvId);
	}

	@GetMapping("/getByCvIdForJobSeeker_UserId")
	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(@RequestParam int userId) {
		return this.cvService.getByCvIdForJobSeeker_UserId(userId);
	}
	@Transactional
	@PostMapping("/updateCvSetCreationDate")
	public Result updateCvSetCreationDate(@RequestParam("cvId") int cvId) {
		return this.cvService.updateCvSetCreationDate(cvId);
	}
}
