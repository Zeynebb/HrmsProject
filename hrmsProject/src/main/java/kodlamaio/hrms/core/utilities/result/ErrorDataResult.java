package kodlamaio.hrms.core.utilities.result;

public class ErrorDataResult<T> extends DataResult<T>{
	
	public ErrorDataResult(T data, String message) {
		super(data, true, message);
	}

	public ErrorDataResult(T data) {
		super(data, true);
	}

	public ErrorDataResult(String message) {
		super(null, false, message);
	}
	public ErrorDataResult() {
		super(null, false);
	}

}
