package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employer")
@Data
public class Employer {

	@Id
	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "password")
	private String password;

	public Employer() {

	}

	public Employer(int employerId, String companyName, String website, String email, String phoneNumber,
			String password) {
		super();
		this.employerId = employerId;
		this.companyName = companyName;
		this.website = website;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

}