package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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

	@OneToOne(mappedBy = "cv",cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CvForeignLanguage cvForeignLanguage;

	@OneToOne(mappedBy = "cv")
	@PrimaryKeyJoinColumn
	private CvSocialMedia cvSocialMedia;

	@OneToOne(mappedBy = "cv")
	@PrimaryKeyJoinColumn
	private CvTechnology cvTechnology;
	
	@OneToOne(mappedBy = "cv")
	@PrimaryKeyJoinColumn
	private EducationInformation educationInformation;
	
	@OneToOne(mappedBy = "cv")
	@PrimaryKeyJoinColumn
	private WorkExperience workExperience;

}
