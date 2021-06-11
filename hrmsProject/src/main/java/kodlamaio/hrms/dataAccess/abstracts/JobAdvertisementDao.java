package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where advertisementStatus=true ORDER BY applicationDeadline DESC")
	List<JobAdvertisement> getAllActiveSorted();
	
	List<JobAdvertisement> getByJobAdvertisementId(int id);

	List<JobAdvertisement> getByAdvertisementStatus(boolean status);
	
	List<JobAdvertisement> getByApprovalStatus(boolean status);

	JobAdvertisement getByJobAdvertisementIdAndEmployer_userId(int jobAdvertisementId, int userId);

	List<JobAdvertisement> getByEmployer_userId(int userId);

	@Modifying
	@Query("update JobAdvertisement set advertisementStatus=false where jobAdvertisementId=:jobAdvertisementId "
			+ "and employer.userId= :employerId")
	int updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(
			@Param("jobAdvertisementId") int jobAdvertisementId, @Param("employerId") int employerId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto"
			+ "(a.id, e.companyName , p.positionName , a.positionAmount, a.releaseDate, a.applicationDeadline)"
			+ " From JobAdvertisement a Inner Join a.employer e Inner Join a.position p")
	List<JobAdvertisementWithEmployerWithJobPositionDto> getJobAdvertisementWithEmployerWithJobPositionDetails();
	
}
