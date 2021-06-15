package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.abstracts.Users;

public interface UserDao extends JpaRepository<Users, Integer> {
	
	@Query("Select u.password From Users u where u.email=?1")
	String getPasswordByEmail(String email);
}
