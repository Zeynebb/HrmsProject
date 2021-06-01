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
@Table(name="universities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "educationInformations"})
public class University {
	
	@Id
	@Column(name="university_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int universityId;
	
	@Column(name="university_name")
	private String universityname;
		
	@OneToMany(mappedBy = "university")
	private List<EducationInformation> educationInformations;

}
