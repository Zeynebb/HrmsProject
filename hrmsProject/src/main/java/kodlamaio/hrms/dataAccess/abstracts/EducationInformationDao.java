package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto;

public interface EducationInformationDao extends JpaRepository<EducationInformation, Integer> {
	
	@Query("Select new kodlamaio.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto("
			+ "e.educationInformationId,j.firstName, j.lastName, c.cvId, u.universityId, "
			+ "u.universityName, d.universityDepartmentId, d.universityDepartmentName, e.startingDate, e.graduationDate) "
			+ "From EducationInformation e Inner Join University u ON e.university.universityId=u.universityId"
			+ " Inner Join UniversityDepartment d ON e.universityDepartment.universityDepartmentId=d.universityDepartmentId"
			+ " Inner Join e.cv c "
			+ " Inner Join JobSeeker j ON e.cv.jobSeeker.userId=j.userId"
			+ " where j.userId=?1")
	List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>
	getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(int userId);
	

}
