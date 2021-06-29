package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteDao;
import kodlamaio.hrms.entities.concretes.Favorite;

@Service
public class FavoriteManager implements FavoriteService {

	private FavoriteDao favoriteDao;

	@Autowired
	public FavoriteManager(FavoriteDao favoriteDao) {
		super();
		this.favoriteDao = favoriteDao;
	}

	@Override
	public Result add(Favorite favorite) {
		this.favoriteDao.save(favorite);
		return new SuccessResult("Favorilere eklendi");
	}

	@Override
	public DataResult<List<Favorite>> getAll() {
		return new SuccessDataResult<List<Favorite>>(this.favoriteDao.findAll(), "Favoriler Listelendi");
	}

	@Override
	public DataResult<List<Favorite>> getFavoriteByJobSeeker_UserId(int userId) {
		return new SuccessDataResult<>(this.favoriteDao.getFavoriteByJobSeeker_UserId(userId),
				"İş arayan favorileri listelendi.");
	}

	@Override
	public DataResult<Favorite> getFavoriteByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId) {
		return new SuccessDataResult<Favorite>(
				this.favoriteDao.getFavoriteByJobAdvertisement_JobAdvertisementId(jobAdvertisementId),
				"Favori ilan listelendi");
	}

	@Override
	public boolean existsByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId) {
		return this.favoriteDao.existsByJobAdvertisement_JobAdvertisementId(jobAdvertisementId);
	}

	@Override
	public boolean existsByJobAdvertisement(int jobAdvertisementId, int jobSeekerId) {
		boolean result = false;
		if (this.favoriteDao.getFavoriteByJobSeekerId(jobSeekerId).contains(jobAdvertisementId) == true) {
			result=true;
		}
		return result;
	}

	@Override
	public DataResult<List<Integer>> getFavoriteByJobSeekerId(int userId) {
		return new SuccessDataResult<List<Integer>>(this.favoriteDao.getFavoriteByJobSeekerId(userId),
				"İş arayan favorileri listelendi");
	}

	@Override
	public Result deleteByFavoriteId(int favoriteId) {
		this.favoriteDao.deleteByFavoriteId(favoriteId);
		return new SuccessResult("Favorilerden Silindi!");
	}

	@Override
	public Result deleteByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId) {
		this.favoriteDao.deleteByJobAdvertisement_JobAdvertisementId(jobAdvertisementId);
		return new SuccessResult("Favorilerden Silindi!");
	}
}
