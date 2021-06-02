package kodlamaio.hrms.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvForeignLanguage"})
public class Cv {

	@Id
	@Column(name = "cv_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvId;

	@Column(name = "photo_link")
	private String photoLink;

	@Column(name = "objective")
	private String objective;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;

	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvForeignLanguage> cvForeignLanguage;

	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvSocialMedia> cvSocialMedia;

	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvTechnology> cvTechnology;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<EducationInformation>  educationInformation;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<WorkExperience>  workExperience;

}
