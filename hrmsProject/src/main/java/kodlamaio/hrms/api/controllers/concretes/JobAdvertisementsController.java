package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getAll")
	public List<JobAdvertisement> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("/getAllActive")
	public DataResult<List<JobAdvertisement>> getByAdvertisementStatus(@RequestParam boolean status) {
		return this.jobAdvertisementService.getByAdvertisementStatus(status);
	}

	@GetMapping("/getAllActiveSorted")
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		return this.jobAdvertisementService.getAllSorted();
	}
	@GetMapping("/getByEmployer_userId")
	public DataResult<List<JobAdvertisement>> getByEmployer_userId(@RequestParam int userId) {
		return this.jobAdvertisementService.getByEmployer_userId(userId);
	}

	@PostMapping("/add")
	public Result jobAdvertisementAdd(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.jobAdvertisementAdd(jobAdvertisement);
	}

}
