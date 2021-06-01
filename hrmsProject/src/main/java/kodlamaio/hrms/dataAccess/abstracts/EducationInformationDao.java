package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.EducationInformation;

public interface EducationInformationDao extends JpaRepository<EducationInformation, Integer>{

}
