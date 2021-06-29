package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Favorite;

public interface FavoriteService {
	
	public Result add(Favorite favorite);
	public DataResult<List<Favorite>> getAll();
	public Result deleteByFavoriteId(int favoriteId);
	public Result deleteByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId);
		
	public boolean existsByJobAdvertisement(int jobAdvertisementId, int jobSeekerId);
	public boolean existsByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId);
	
	public DataResult<List<Favorite>> getFavoriteByJobSeeker_UserId(int userId);
	
	public DataResult<List<Integer>> getFavoriteByJobSeekerId(int userId);
	
	public DataResult<Favorite> getFavoriteByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId);

}
