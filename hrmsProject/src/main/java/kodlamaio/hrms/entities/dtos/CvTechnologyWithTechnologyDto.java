package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvTechnologyWithTechnologyDto {
	
	private int cvTechnologyId;
	private int technologyId;
	private String technologyname;	

}
