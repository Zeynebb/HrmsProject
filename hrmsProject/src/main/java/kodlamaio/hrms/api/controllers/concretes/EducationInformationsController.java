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
import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto;

@RestController
@RequestMapping("/api/educationInformation")
@CrossOrigin
public class EducationInformationsController {

	private EducationInformationService educationInformationService;

	@Autowired
	public EducationInformationsController(EducationInformationService educationInformationService) {
		super();
		this.educationInformationService = educationInformationService;
	}

	@GetMapping("/getAll")
	public DataResult<List<EducationInformation>> getAll() {
		return this.educationInformationService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody EducationInformation educationInformation) {
		return this.educationInformationService.add(educationInformation);
	}
	@Transactional
	@PostMapping("/deleteEducation")
	public Result deleteByEducationInformationId(int educationId) {
		return this.educationInformationService.deleteByEducationInformationId(educationId);
	}

	@GetMapping("/getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails")
	public DataResult<List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>> getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(
			@RequestParam int cvId) {
		return this.educationInformationService
				.getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(cvId);
	}

	@GetMapping("/getEducationInformationDetails")
	public DataResult<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto> getEducationInformationDetails(
			@RequestParam("educationId") int educationId) {
		return this.educationInformationService.getEducationInformationDetails(educationId);
	}

}
