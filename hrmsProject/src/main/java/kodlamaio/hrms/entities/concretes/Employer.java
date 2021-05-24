package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import kodlamaio.hrms.entities.abstracts.Entities;
import kodlamaio.hrms.entities.abstracts.Users;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Employer extends Users implements Entities {
	
	@Id
	@Column(name = "user_id")
	@PrimaryKeyJoinColumn
	private int userId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name="verification_status")
	private boolean verificationStatus;

	public Employer(String email, String password, String companyName, String website, String phoneNumber,boolean verificationStatus) {
		super(email, password);
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
		this.verificationStatus=verificationStatus;
	}

}