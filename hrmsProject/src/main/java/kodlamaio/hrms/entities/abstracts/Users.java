package kodlamaio.hrms.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "system_users")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	public Users(String email, String password) {
		this.email=email;
		this.password=password;
	}

}
