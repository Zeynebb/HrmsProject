package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvForeignLanguageWithForeignLanguageDto {
	
	private int cvForeignLanguageId;
	private int foreignLanguageId;
	private String foreignLanguageName;
	private int languageLevelId;
	private String languageLevelName;
	
	
	
}
