package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceWithCvWithJobSeekerDto {
	
	private int workExperienceId;
	private String workplaceName;
	private Date startingDate;
	private Date endingdate;
	private String positionName;
	private String jobSeekerFirstname;
	private String jobSeekerLastname;

}
