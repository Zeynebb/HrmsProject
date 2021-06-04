package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name="work_experience_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workExperienceId;

	@Column(name="workplace_name")
	private String workplaceName;
	
	@Column(name="starting_date")
	private String startingDate;
	
	@Column(name="ending_date")
	private String endingDate;
	
	
	@ManyToOne
	@JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
	private Cv cv;
		
	
	@ManyToOne
	@JoinColumn(name="position_id")
	private JobPosition jobPosition;
	
	
	
}
