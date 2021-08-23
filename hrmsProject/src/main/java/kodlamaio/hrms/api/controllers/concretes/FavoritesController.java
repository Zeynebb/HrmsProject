package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Favorite;

@RestController
@RequestMapping("/api/favorite")
@CrossOrigin
public class FavoritesController {

	private FavoriteService favoriteService;

	@Autowired
	public FavoritesController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Favorite favorite) {
		return this.favoriteService.add(favorite);
	}
	@PostMapping("/delete")
	@Transactional
	public Result deleteByFavoriteId(@RequestParam int favoriteId) {
		return this.favoriteService.deleteByFavoriteId(favoriteId);
	}
	@PostMapping("/deleteByJobAdvertisementId")
	@Transactional
	public Result deleteByJobAdvertisement_JobAdvertisementId(@RequestParam int jobAdvertisementId) {
		return this.favoriteService.deleteByJobAdvertisement_JobAdvertisementId(jobAdvertisementId);
	}

	@GetMapping("/getAll")
	public DataResult<List<Favorite>> getAll() {
		return this.favoriteService.getAll();
	}

	@GetMapping("/getFavoritesByJobSeekerId")
	public DataResult<List<Favorite>> getFavoriteByJobSeeker_UserId(@RequestParam int userId) {
		return this.favoriteService.getFavoriteByJobSeeker_UserId(userId);
	}

	@GetMapping("/existsJobAdvertisement")
	public boolean existsByJobAdvertisement_JobAdvertisementId(@RequestParam int jobAdvertisementId) {
		return this.favoriteService.existsByJobAdvertisement_JobAdvertisementId(jobAdvertisementId);
	}

	@GetMapping("/getFavoriteIdByJobSeekerId")
	public DataResult<List<Integer>> getFavoriteByJobSeekerId(@RequestParam int userId) {
		return this.favoriteService.getFavoriteByJobSeekerId(userId);
	}

	@GetMapping("/getFavoritesByJobAdvertisementId")
	public DataResult<Favorite> getFavoriteByJobAdvertisement_JobAdvertisementId(@RequestParam int jobAdvertisementId) {
		return this.favoriteService.getFavoriteByJobAdvertisement_JobAdvertisementId(jobAdvertisementId);
	}

	@GetMapping("/existsByJobAdvertisement")
	public boolean existsByJobAdvertisement(@RequestParam("jobAdvertisementId") int jobAdvertisementId,
			@RequestParam("jobSeekerId") int jobSeekerId) {
		return this.favoriteService.existsByJobAdvertisement(jobAdvertisementId, jobSeekerId);
	}

}
