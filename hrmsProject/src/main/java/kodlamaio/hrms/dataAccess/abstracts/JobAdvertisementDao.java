package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where advertisementStatus=?1 ORDER BY applicationDeadline DESC")
	List<JobAdvertisement> getAllSortedJobAdvertisementByStatus(boolean status);
	
	@Query("From JobAdvertisement j where j.advertisementStatus=?1 and j.employer.userId=?2 ORDER BY applicationDeadline DESC")
	List<JobAdvertisement> getAllSortedJobAdvertisementByStatusForEmployerId(boolean status, int employerId);
	
	JobAdvertisement getByJobAdvertisementId(int id);

	List<JobAdvertisement> getByAdvertisementStatus(boolean status);
	
	List<JobAdvertisement> getByApprovalStatus(boolean status);

	JobAdvertisement getByJobAdvertisementIdAndEmployer_userId(int jobAdvertisementId, int userId);

	List<JobAdvertisement> getByEmployer_userId(int userId);

	@Modifying
	@Query("update JobAdvertisement set advertisementStatus=?3 "
			+ "where jobAdvertisementId=?1 "
			+ "and employer.userId=?2 ")
	int updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(
			int jobAdvertisementId, int employerId, boolean status);
	
	@Modifying
	@Query("update JobAdvertisement set approvalStatus=?2 "
			+ "where jobAdvertisementId=?1")
	int updateJobAdvertisementSetApprovalStatus(int jobAdvertisementId, boolean status);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto"
			+ "(a.jobAdvertisementId, e.companyName , p.positionName , a.positionAmount, a.releaseDate, a.applicationDeadline)"
			+ " From JobAdvertisement a Inner Join a.employer e Inner Join a.position p")
	List<JobAdvertisementWithEmployerWithJobPositionDto> getJobAdvertisementWithEmployerWithJobPositionDetails();
	
}
