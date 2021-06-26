package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceWithCvWithJobPositionDto {
	
	private int workExperienceId;
	private int jobPositionId;
	private String workplaceName;
	private Date startingDate;
	private Date endingdate;
	private String positionName;

}
