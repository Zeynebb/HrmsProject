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
@Table(name="social_media")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvSocialMedia"})
public class SocialMedia {
	
	@Id
	@Column(name="social_media_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int socialMediaId;
	
	@Column(name="social_media_name")
	private String socialMediaName;

	
	@OneToMany(mappedBy = "socialMedia")
	List<CvSocialMedia> cvSocialMedia;

}
