package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformationWithCvWithUniversityWithUniversityDepartmentDto {

	private int educationId;
	private int cvId;
	private int universityId;
	private String universityName;
	private int departmentId;
	private String universityDepartmentName;
	private Date startingDate;
	private String graduationDate;

	public EducationInformationWithCvWithUniversityWithUniversityDepartmentDto(int educationId, int universityId,
			String universityName, int departmentId, String universityDepartmentName, Date startingDate,
			String graduationDate) {
		super();
		this.educationId = educationId;
		this.universityId = universityId;
		this.universityName = universityName;
		this.departmentId = departmentId;
		this.universityDepartmentName = universityDepartmentName;
		this.startingDate = startingDate;
		this.graduationDate = graduationDate;
	}

}
