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
@Table(name="work_experiences")
public class WorkExperience {
	
	@Id
	@Column(name="cv_id")
	private int cvId;

	@Column(name="workplace_name")
	private String workplaceName;
	
	@Column(name="starting_date")
	private String startingDate;
	
	@Column(name="graduation_date")
	private String graduationDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
    @JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
    private Cv cv;
		
	@ManyToOne
	@JoinColumn(name="position_id")
	private JobPosition jobPosition;
	
	
	
}
