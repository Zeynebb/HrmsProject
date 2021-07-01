package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.abstracts.Users;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	@GetMapping("/getAll")
	public DataResult<List<Users>> getAll(){
		return this.userService.getAll();
	}

	@Transactional
	@PostMapping("/updatePassword")
	public Result updateUserSetPassword(@RequestParam("userId") int userId, @RequestParam("password") String password,
			@RequestParam("passwordAgain") String passwordAgain) {
		return this.userService.updateUserSetPassword(userId, password, passwordAgain);
	}

}
