package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvForeignLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvForeignLanguage;
import kodlamaio.hrms.entities.dtos.CvForeignLanguageWithForeignLanguageDto;

@RestController
@RequestMapping("/api/cvForeignLanguage")
public class CvForeignLanguagesController {
	
	private CvForeignLanguageService cvForeignLanguageService;
	
	@Autowired
	public CvForeignLanguagesController(CvForeignLanguageService cvForeignLanguageService) {
		super();
		this.cvForeignLanguageService = cvForeignLanguageService;
	}
	@GetMapping("/getAll")
	public DataResult<List<CvForeignLanguage>> getAll(){
		return this.cvForeignLanguageService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody CvForeignLanguage cvForeignLanguage) {
		return this.cvForeignLanguageService.add(cvForeignLanguage);
	}
	@Transactional
	@PostMapping("/deleteCvForeignLanguage")
	public Result deleteByForeignLanguageId(int foreignLanguageId) {
		return this.cvForeignLanguageService.deleteByForeignLanguageId(foreignLanguageId);
	}
		
	@GetMapping("/getCvForeignLanguageWithForeignLanguageDetails")
	public DataResult<List<CvForeignLanguageWithForeignLanguageDto>> getCvForeignLanguageWithForeignLanguageDetails(
			@RequestParam int cvId){
		return this.cvForeignLanguageService.getCvForeignLanguageWithForeignLanguageDetails(cvId);
	}

}
