package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

@RestController
@RequestMapping("/api/foreignLanguage")
public class ForeignLanguagesController {

	private ForeignLanguageService foreignLanguageService;
	
	@Autowired
	public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}

	@GetMapping("/getAll")
	public DataResult<List<ForeignLanguage>> getAll() {
		return this.foreignLanguageService.getAll();
	}
}
