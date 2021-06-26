package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto;

public interface EducationInformationDao extends JpaRepository<EducationInformation, Integer> {
	
	@Query("Select new kodlamaio.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto("
			+ "e.educationInformationId, c.cvId, u.universityId, "
			+ "u.universityName, d.universityDepartmentId, d.universityDepartmentName, e.startingDate, e.graduationDate) "
			+ "From EducationInformation e Inner Join University u ON e.university.universityId=u.universityId"
			+ " Inner Join UniversityDepartment d ON e.universityDepartment.universityDepartmentId=d.universityDepartmentId"
			+ " Inner Join e.cv c"
			+ " where e.cv.cvId=?1 ORDER BY e.graduationDate DESC")
	List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>
	getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(int cvId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto("
			+ "e.educationInformationId,u.universityId, "
			+ "u.universityName, d.universityDepartmentId, d.universityDepartmentName, e.startingDate, e.graduationDate) "
			+ "From EducationInformation e Inner Join University u ON e.university.universityId=u.universityId"
			+ " Inner Join UniversityDepartment d ON e.universityDepartment.universityDepartmentId=d.universityDepartmentId "
			+ " where e.educationInformationId=?1 ORDER BY e.graduationDate DESC")
	EducationInformationWithCvWithUniversityWithUniversityDepartmentDto	getEducationInformationDetails(int educationId);
	
}
