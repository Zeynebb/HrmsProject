package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.abstracts.Users;

public interface UserDao extends JpaRepository<Users, Integer> {

}
