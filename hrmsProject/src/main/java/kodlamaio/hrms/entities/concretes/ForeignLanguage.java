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
@Table(name="foreign_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvForeignLanguages"})
public class ForeignLanguage {
	
	@Id
	@Column(name="foreign_language_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foreignLanguageId;
	
	@Column(name="foreign_language_name")
	private String foreignLanguageName;

	@OneToMany(mappedBy = "foreignLanguage")
	private List<CvForeignLanguage> cvForeignLanguages;
	
}
