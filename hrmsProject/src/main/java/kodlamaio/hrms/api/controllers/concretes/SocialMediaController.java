package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.SocialMedia;

@RestController
@RequestMapping("/api/socialMedia")
public class SocialMediaController {
	
	private SocialMediaService socialMediaService;
	
	@Autowired
	public SocialMediaController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}

	@GetMapping("/getAll")
	public DataResult<List<SocialMedia>> getAll(){
		return this.socialMediaService.getAll();
	}

}
