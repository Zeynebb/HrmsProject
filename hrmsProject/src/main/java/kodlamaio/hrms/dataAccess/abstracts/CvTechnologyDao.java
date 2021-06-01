package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.CvTechnology;

public interface CvTechnologyDao extends JpaRepository<CvTechnology, Integer>{

}
