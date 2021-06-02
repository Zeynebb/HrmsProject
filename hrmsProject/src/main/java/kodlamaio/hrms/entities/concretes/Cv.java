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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
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

	@OneToMany(mappedBy = "cv")
	private List<CvForeignLanguage> cvForeignLanguage;

	@OneToMany(mappedBy = "cv")
	private List<CvSocialMedia> cvSocialMedia;

	@OneToMany(mappedBy = "cv")
	private List<CvTechnology> cvTechnology;
	
	@OneToMany(mappedBy = "cv")
	private List<EducationInformation>  educationInformation;
	
	@OneToMany(mappedBy = "cv")
	private List<WorkExperience>  workExperience;

}
