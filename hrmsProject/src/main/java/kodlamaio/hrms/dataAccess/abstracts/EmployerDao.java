
package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	@Modifying
	@Query("update Employer set verificationStatus=true where userId=:employerId")
	int updateEmployerSetVerificationStatusForUserId(@Param("employerId") int employerId);
	

}
