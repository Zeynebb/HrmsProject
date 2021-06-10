package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UniversityDepartmentDao;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;

@Service
public class UniversityDepartmentManager implements UniversityDepartmentService{

	private UniversityDepartmentDao universityDepartmentDao;
	
	@Autowired
	public UniversityDepartmentManager(UniversityDepartmentDao universityDepartmentDao) {
		super();
		this.universityDepartmentDao = universityDepartmentDao;
	}


	@Override
	public DataResult<List<UniversityDepartment>> getAll() {
		return new SuccessDataResult<List<UniversityDepartment>>(this.universityDepartmentDao.findAll(),"Bölümler Listelendi");
	}

}
