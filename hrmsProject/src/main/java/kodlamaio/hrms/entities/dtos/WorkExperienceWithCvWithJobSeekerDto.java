package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceWithCvWithJobSeekerDto {
	
	private int workExperienceId;
	private String workplaceName;
	private String startingDate;
	private String endingdate;
	private String positionName;
	private String jobSeekerFirstname;
	private String jobSeekerLastname;

}
