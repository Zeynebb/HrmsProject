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

import kodlamaio.hrms.business.abstracts.CvTechnologyService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvTechnology;
import kodlamaio.hrms.entities.dtos.CvTechnologyWithTechnologyDto;

@RestController
@RequestMapping("/api/cvTechnology")
@CrossOrigin
public class CvTechnologiesController {
	
	private CvTechnologyService cvTechnologyService;

	@Autowired
	public CvTechnologiesController(CvTechnologyService cvTechnologyService) {
		super();
		this.cvTechnologyService = cvTechnologyService;
	}
	@GetMapping("/getAll")
	public DataResult<List<CvTechnology>> getAll(){
		return this.cvTechnologyService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvTechnology cvTechnology) {
		return this.cvTechnologyService.add(cvTechnology);
	}
	@Transactional
	@PostMapping("/deleteCvTechnology")
	public Result deleteByCvTechnologiesId(int cvTechnologiesId) {
		return this.cvTechnologyService.deleteByCvTechnologiesId(cvTechnologiesId);
	}
	
	@GetMapping("/getCvTechnologyWithTechnologydetails")
	public DataResult<List<CvTechnologyWithTechnologyDto>> getCvTechnologyWithTechnologydetails(@RequestParam int cvId){
		return this.cvTechnologyService.getCvTechnologyWithTechnologydetails(cvId);
	}
	

}
