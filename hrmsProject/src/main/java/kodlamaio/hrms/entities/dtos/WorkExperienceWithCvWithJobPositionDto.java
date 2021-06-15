package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceWithCvWithJobPositionDto {
	
	private String workplaceName;
	private String startingDate;
	private String endingdate;
	private String positionName;

}
