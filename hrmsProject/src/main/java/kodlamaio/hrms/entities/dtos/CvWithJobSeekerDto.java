package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvWithJobSeekerDto {
	
	private String objective;
	private String firstName;
	private String lastName;
	private String email;
	private int birthYear;

}
