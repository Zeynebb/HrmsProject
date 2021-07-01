package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.abstracts.Users;

public interface UserDao extends JpaRepository<Users, Integer> {
	
	@Query("Select u.password From Users u where u.email=?1")
	String getPasswordByEmail(String email);
	
	@Modifying
	@Query("update Users set password=?2 "
			+ "where userId=?1")
	int updateUserSetPassword(int userId, String password);
	
}
