package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobPositionDto;
import kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer>{
	
	Long deleteByCv_CvId(int cvId);
	
	Long deleteByWorkExperienceId(int workExperienceId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobPositionDto("
			+ "w.workExperienceId,p.positionId, w.workplaceName, w.startingDate, w.endingDate, p.positionName) "
			+ "From WorkExperience w Inner Join Cv c ON w.cv.cvId=c.cvId "
			+ "Inner Join JobPosition p ON w.jobPosition.positionId=p.positionId "
			+ "where w.cv.cvId=?1 ORDER BY w.endingDate DESC")
	List<WorkExperienceWithCvWithJobPositionDto> getWorkExperienceWithCvWithJobPositionDetails(int cvId);

	
	@Query("Select new kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto("
			+ "w.workExperienceId,w.workplaceName, w.startingDate, w.endingDate, p.positionName, j.firstName, j.lastName ) "
			+ "From WorkExperience w Inner Join Cv c ON w.cv.cvId=c.cvId "
			+ "Inner Join JobSeeker j ON w.cv.jobSeeker.userId=j.userId "
			+ "Inner Join JobPosition p ON w.jobPosition.positionId=p.positionId "
			+ "where w.cv.jobSeeker.userId=?1 ORDER BY w.endingDate DESC")
	List<WorkExperienceWithCvWithJobSeekerDto> getWorkExperienceWithCvWithJobSeekerDateils(int userId);
	
}
