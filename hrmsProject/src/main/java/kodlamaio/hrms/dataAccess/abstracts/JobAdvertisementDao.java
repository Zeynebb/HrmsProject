package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByAdvertisementStatus(boolean status);

	JobAdvertisement getByJobAdvertisementIdAndEmployer_userId(int jobAdvertisementId, int userId);

	List<JobAdvertisement> getByEmployer_userId(int userId);

}
