package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.WorkType;

@CrossOrigin
@RestController
@RequestMapping("/api/workType")
public class WorkTypesController {
	
	private WorkTypeService workTypeService;
	
	@Autowired
	public WorkTypesController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}

	@GetMapping("/getAll")
	public DataResult<List<WorkType>> getAll(){
		return this.workTypeService.getAll();
	}

}
