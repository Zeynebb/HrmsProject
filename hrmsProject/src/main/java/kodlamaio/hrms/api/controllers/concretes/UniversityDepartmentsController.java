package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;

@RestController
@RequestMapping("/api/universityDepartment")
public class UniversityDepartmentsController {
	
	private UniversityDepartmentService universityDepartmentService;
	
	
	@Autowired
	public UniversityDepartmentsController(UniversityDepartmentService universityDepartmentService) {
		super();
		this.universityDepartmentService = universityDepartmentService;
	}

	@GetMapping("/getAll")
	public DataResult<List<UniversityDepartment>> getAll(){
		return this.universityDepartmentService.getAll();
	}

}
