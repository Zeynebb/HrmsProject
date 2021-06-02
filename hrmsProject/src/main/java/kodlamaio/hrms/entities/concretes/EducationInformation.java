package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
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
@Table(name="education_informations")
public class EducationInformation {
	
	@Id
	@Column(name="education_information_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationInformationId;
	
	@Column(name="starting_date")
	private String startingDate;
	
	@Column(name="graduation_date")
	private String graduationDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
	private Cv cv;
	
	@ManyToOne
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne
	@JoinColumn(name="university_department_id")
	private UniversityDepartment universityDepartment;

}
