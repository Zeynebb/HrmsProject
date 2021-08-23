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

import kodlamaio.hrms.business.abstracts.CvSocialMediaService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvSocialMedia;
import kodlamaio.hrms.entities.dtos.CvSocialMediaWithSocialMediaDto;

@RestController
@RequestMapping("/api/cvSocialMedia")
@CrossOrigin
public class CvSocialMediaController {
	
	private CvSocialMediaService cvSocialMediaService;

	@Autowired
	public CvSocialMediaController(CvSocialMediaService cvSocialMediaService) {
		super();
		this.cvSocialMediaService = cvSocialMediaService;
	}
	@GetMapping("/getAll")
	public DataResult<List<CvSocialMedia>> getAll(){
		return this.cvSocialMediaService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSocialMedia cvSocialMedia) {
		return this.cvSocialMediaService.add(cvSocialMedia);
	}
	
	@Transactional
	@PostMapping("/deleteByCvSocialMediaId")
	public Result deleteByCvSocialMediaId(int cvSocialMediaId) {
		return this.cvSocialMediaService.deleteByCvSocialMediaId(cvSocialMediaId);
	}
	
	@GetMapping("/getCvSocialMediaWithSocialMediaDetails")
	public DataResult<List<CvSocialMediaWithSocialMediaDto>> getCvSocialMediaWithSocialMediaDetails(@RequestParam int cvId){
		return this.cvSocialMediaService.getCvSocialMediaWithSocialMediaDetails(cvId);
	}

}
