package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer>{

	
	@Query("Select new kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto("
			+ "w.workExperienceId,w.workplaceName, w.startingDate, w.endingDate, p.positionName, j.firstName, j.lastName ) "
			+ "From WorkExperience w Inner Join Cv c ON w.cv.cvId=c.cvId "
			+ "Inner Join JobSeeker j ON w.cv.jobSeeker.userId=j.userId "
			+ "Inner Join JobPosition p ON w.jobPosition.positionId=p.positionId "
			+ "where w.cv.jobSeeker.userId=?1")
	List<WorkExperienceWithCvWithJobSeekerDto> getWorkExperienceWithCvWithJobSeekerDateils(int userId);
	
	
	
	/*@Query("Select new kodlamaio.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto("
			+ "e.educationInformationId, c.cvId, u.universityId, u.universityName, d.universityDepartmentId, d.universityDepartmentName) "
			+ "From EducationInformation e Inner Join University u ON e.university.universityId=u.universityId"
			+ " Inner Join UniversityDepartment d ON e.universityDepartment.universityDepartmentId=d.universityDepartmentId"
			+ " Inner Join e.cv c"
			+ " where c.cvId=?1")
	List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>
	getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(int cvId);
	private int workExperienceId;
	private String workplaceName;
	private String startingDate;
	private String endingdate;
	private String positionName;
	private String jobSeekerFirstname;
	private String jobSeekerLastname;
	*/
}
