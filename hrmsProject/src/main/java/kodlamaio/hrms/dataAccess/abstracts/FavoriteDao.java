package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Integer>{

	@Query("Select f.jobAdvertisement.jobAdvertisementId From Favorite f where f.jobSeeker.userId=?1")
	public List<Integer> getFavoriteByJobSeekerId(int userId);
	
	Long deleteByFavoriteId(int favoriteId);
	Long deleteByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId);
	
	public List<Favorite> getFavoriteByJobSeeker_UserId(int userId);
	
	boolean existsByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId);
	
	public Favorite getFavoriteByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId);
}
