package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cv_foreign_languages")
public class CvForeignLanguage {
	
	@Id
	@Column(name="cv_id")
	private int cvId;
	
	@OneToOne()
	@MapsId
    @JoinColumn(name = "cv_id")
    private Cv cv;
	
	@ManyToOne
	@JoinColumn(name="language_level_id")
	private LanguageLevel languageLevel;
	
	@ManyToOne
	@JoinColumn(name="foreign_language_id")
	private ForeignLanguage foreignLanguage;
	
	

}
