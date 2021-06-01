package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;

public interface UniversityDepartmentDao extends JpaRepository<UniversityDepartment, Integer>{

}
