package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cv_technologies")
public class CvTechnology {
	
	@Id
	@Column(name="cv_technologies_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvTechnologiesId;
		
	@ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;
	
	@ManyToOne
	@JoinColumn(name="technology_id")
	private Technology technology;
	
	

}
