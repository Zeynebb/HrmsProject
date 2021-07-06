package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvWithJobSeekerDto;

public interface CvDao extends JpaRepository<Cv, Integer>{
	
	@Query("From Cv c where c.jobSeeker.userId=?1")
	List<Cv> getByCvIdForJobSeekerId(int userId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CvWithJobSeekerDto(c.cvId, c.objective, j.firstName, j.lastName, "
			+ "j.email, j.birthYear) "
			+ "From Cv c INNER JOIN c.jobSeeker j "
			+ " where c.cvId = ?1")
	List<CvWithJobSeekerDto> getCvWithJobSeekerDetails(int cvId);	
	
	@Modifying
	@Query("update Cv set creationDate=?2 "
			+ "where cvId=?1")
	int updateCvSetCreationDate(int cvId, Date creationDate);
	
		
}
