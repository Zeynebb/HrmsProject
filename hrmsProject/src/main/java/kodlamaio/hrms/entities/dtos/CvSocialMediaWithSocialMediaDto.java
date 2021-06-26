package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvSocialMediaWithSocialMediaDto {
	
	private int cvSocialMediaId;
	private int socialMediaId;
	private String socialMediaName;
	private String link;
	
	

}
