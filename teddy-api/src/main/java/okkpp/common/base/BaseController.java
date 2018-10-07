package okkpp.common.base;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import okkpp.common.result.Result;

@Component
public class BaseController {

	protected Result<String> successMsg(String msg){
		return Result.success(msg);
	}
	protected Result<String> faildMsg(String msg){
		return Result.failed(msg);
	}
	protected <T> Result<T> successData(T data){
		return new Result<>(data);
	}
	@ExceptionHandler(value = Exception.class)
    public Result<String> baseExceptionHandler(Exception e) {
		Result<String> result = faildMsg(e.getMessage());
		return result;
    }
}
