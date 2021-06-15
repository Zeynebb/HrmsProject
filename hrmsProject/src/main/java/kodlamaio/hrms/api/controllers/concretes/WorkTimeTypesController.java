package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTimeTypeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.WorkTimeType;

@CrossOrigin
@RestController
@RequestMapping("/api/workTimeType")
public class WorkTimeTypesController {
	
	private WorkTimeTypeService workTimeTypeService;
	
	@Autowired
	public WorkTimeTypesController(WorkTimeTypeService workTimeTypeService) {
		super();
		this.workTimeTypeService = workTimeTypeService;
	}

	@GetMapping("/getAll")
	public DataResult<List<WorkTimeType>> getAll(){
		return this.workTimeTypeService.getAll();
	}

}
