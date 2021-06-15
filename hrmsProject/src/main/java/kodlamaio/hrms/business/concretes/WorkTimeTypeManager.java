package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkTimeTypeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTimeTypeDao;
import kodlamaio.hrms.entities.concretes.WorkTimeType;

@Service
public class WorkTimeTypeManager implements WorkTimeTypeService{
	
	private WorkTimeTypeDao workTimeTypeDao;
	
	@Autowired
	public WorkTimeTypeManager(WorkTimeTypeDao workTimeTypeDao) {
		super();
		this.workTimeTypeDao = workTimeTypeDao;
	}


	@Override
	public DataResult<List<WorkTimeType>> getAll() {
		return new SuccessDataResult<List<WorkTimeType>>(this.workTimeTypeDao.findAll());
	}

}
