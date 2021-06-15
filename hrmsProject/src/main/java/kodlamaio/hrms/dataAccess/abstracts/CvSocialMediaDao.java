package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CvSocialMedia;
import kodlamaio.hrms.entities.dtos.CvSocialMediaWithSocialMediaDto;

public interface CvSocialMediaDao extends JpaRepository<CvSocialMedia, Integer>{
	
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CvSocialMediaWithSocialMediaDto(s.socialMediaName, "
			+ " c.link) "
			+ "From CvSocialMedia c INNER JOIN c.socialMedia s "
			+ " where c.cv.cvId = ?1")
	List<CvSocialMediaWithSocialMediaDto> getCvSocialMediaWithSocialMediaDetails(int cvId);

}
