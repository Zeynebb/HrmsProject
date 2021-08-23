package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.abstracts.Users;

public interface UserService {
	
	public DataResult<List<Users>> getAll();
	
	public DataResult<List<String>> getAllEmail();

	public Result updateUserSetPassword(int userId, String password, String passwordAgain);
}
