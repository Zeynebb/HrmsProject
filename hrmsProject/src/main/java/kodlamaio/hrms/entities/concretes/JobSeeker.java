package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.abstracts.Entities;
import kodlamaio.hrms.entities.abstracts.Users;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_seekers")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvs"})
public class JobSeeker extends Users implements Entities {
		
	@Id
	@Column(name="user_id")
	@PrimaryKeyJoinColumn
	private int userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationality_id")
	private String nationalityId;

	@Column(name = "birth_year")
	private int birthYear;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Cv> cvs;

	public JobSeeker(String email, String password, String firstName, String lastName, String nationalityId,
			int birthYear) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.birthYear = birthYear;
	}

}
