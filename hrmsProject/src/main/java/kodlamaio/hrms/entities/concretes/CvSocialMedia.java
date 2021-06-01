package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_social_media")
public class CvSocialMedia {

	@Id
	@Column(name="cv_id")
	private int cvId;
	
	@Column(name = "link")
	private String link;

	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
	private Cv cv;

	@ManyToOne
	@JoinColumn(name = "social_media_id")
	private SocialMedia socialMedia;

}