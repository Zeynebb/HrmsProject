package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService{
	
	private WorkTypeDao worktypeDao;
	
	@Autowired
	public WorkTypeManager(WorkTypeDao worktypeDao) {
		super();
		this.worktypeDao = worktypeDao;
	}
	@Override
	public DataResult<List<WorkType>> getAll() {
		return new SuccessDataResult<List<WorkType>>(this.worktypeDao.findAll(), "Çalışma Şekilleri Listelendi.");
	}

}
