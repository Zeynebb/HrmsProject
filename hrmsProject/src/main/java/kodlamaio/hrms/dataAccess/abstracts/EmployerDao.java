
package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	@Modifying
	@Query("update Employer set verificationStatus=?2 where userId=?1")
	int updateEmployerSetVerificationStatusForUserId(int employerId, boolean status);
	
	Employer getByUserId(int userId);
	
	List<Employer> getAllEmployerByVerificationStatus(boolean status);
	
	@Query("Select e.update From Employer e where e.userId=?1")
	Map<String, Object> getUpdateByUserId(int userId);
		
	List<Employer> findByUpdateNotNull();

}
