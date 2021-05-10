package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "job_seeker")
@Data
public class JobSeeker {

	@Id
	@Column(name = "job_seeker_id")
	private int jobSeekerId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationality_id")
	private String nationalityId;

	@Column(name = "birth_year")
	private int birthYear;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

}
