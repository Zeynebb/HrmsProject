package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByAdvertisementStatus(boolean status);

	JobAdvertisement getByJobAdvertisementIdAndEmployer_userId(int jobAdvertisementId, int userId);

	List<JobAdvertisement> getByEmployer_userId(int userId);

	@Modifying
	@Query("update JobAdvertisement set advertisementStatus=false where jobAdvertisementId=:jobAdvertisementId and employer.userId= :employerId")
	int updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(
			@Param("jobAdvertisementId") int jobAdvertisementId, @Param("employerId") int employerId);

}
