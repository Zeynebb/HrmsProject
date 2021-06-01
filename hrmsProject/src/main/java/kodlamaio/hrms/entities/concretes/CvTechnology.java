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
import lombok.Data;

@Data
@Entity
@Table(name="cv_technologies")
public class CvTechnology {
	
	@Id
	@Column(name="cv_id")
	private int cvId;
		
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
    @JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
    private Cv cv;
	
	@ManyToOne
	@JoinColumn(name="technology_id")
	private Technology technology;
	
	

}
