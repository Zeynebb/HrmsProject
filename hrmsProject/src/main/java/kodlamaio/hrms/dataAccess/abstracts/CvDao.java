package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{
	
	
	@Query("From Cv c where c.jobSeeker.userId=?1")
	List<Cv> getByCvIdForJobSeekerId(int userId);

}
