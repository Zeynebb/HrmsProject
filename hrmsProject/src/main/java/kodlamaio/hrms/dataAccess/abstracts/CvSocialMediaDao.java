package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.CvSocialMedia;

public interface CvSocialMediaDao extends JpaRepository<CvSocialMedia, Integer>{

}
