package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer>{
	
	
	@Modifying
	@Query("update Photo set photoUrl=:url where cv.cvId=:cvId")
	int updatePhotoSetPhotoUrlForCv_cvId(@Param("url") String url,@Param("cvId") int cvId);
	
	/*
	@Modifying
	@Query("INSERT INTO Photo (photoUrl, cvId) VALUES (:photoUrl, :cvId)")
	int insertPhoto(@Param("url") String url,@Param("cvId") int cvId);*/
	
	
	/*@Modifying
	@Query("update JobAdvertisement set advertisementStatus=false where jobAdvertisementId=:jobAdvertisementId "
			+ "and employer.userId= :employerId")
	int updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(
			@Param("jobAdvertisementId") int jobAdvertisementId, @Param("employerId") int employerId);*/

}
