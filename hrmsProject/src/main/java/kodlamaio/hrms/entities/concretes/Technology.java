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
@Table(name="technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvTechnologies"})
public class Technology {

	@Id
	@Column(name="technology_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int technologyId;
	
	@Column(name="technology_name")
	private String technologyName;
	
	@OneToMany(mappedBy = "technology")
	List<CvTechnology> cvTechnologies;
	
}
