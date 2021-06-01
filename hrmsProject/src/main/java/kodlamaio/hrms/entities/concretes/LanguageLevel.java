package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="language_levels")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvForeignLanguages"})
public class LanguageLevel {
	
	@Id
	@Column(name="language_level_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int languageLevelId;
	
	@Column(name="language_level_name")
	private String languageLevelname;
		
	@OneToMany(mappedBy = "languageLevel")
	private List<CvForeignLanguage> cvForeignLanguages;

}
