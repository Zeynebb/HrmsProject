package kodlamaio.hrms.entities.concretes;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisement" })
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Employer extends Users implements Entities {

	@Id
	@Column(name = "user_id")
	@PrimaryKeyJoinColumn
	private int userId;

	@NotNull(message = "Şirket ismi boş bırakılamaz!")
	@NotBlank
	@Column(name = "company_name")
	private String companyName;

	@NotNull
	@NotBlank
	@Column(name = "website")
	private String website;

	@NotNull
	@NotBlank
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "verification_status")
	private boolean verificationStatus;

	@Column(name = "update_status")
	private boolean updateStatus;

	@Column(name = "update_employer")
	@Type(type = "jsonb")
	private Map<String, Object> update;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisement;

	public Employer(String email, String password, String companyName, String website, String phoneNumber,
			boolean verificationStatus, boolean updateStatus, Map<String, Object> update,
			List<JobAdvertisement> jobAdvertisement) {
		super(email, password);
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
		this.verificationStatus = verificationStatus;
		this.updateStatus = updateStatus;
		this.update = update;
		this.jobAdvertisement = jobAdvertisement;
	}

}