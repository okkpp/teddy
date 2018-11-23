package okkpp.common.base;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;

import okkpp.common.result.Result;

@Component
@Validated
public class BaseController {

	protected Result<String> result(boolean result){
		if(result) {
			return successMsg("请求成功");
		}
		return faildMsg("请求失败");
	}
	protected <T> Result<T> resultData(T data){
		return new Result<>(data);
	}
	protected Result<String> successMsg(String msg){
		return Result.success(msg);
	}
	protected Result<String> faildMsg(String msg){
		return Result.failed(msg);
	}
	
	@ExceptionHandler(value = Exception.class)
    public Result<String> baseExceptionHandler(Exception e) {
		return faildMsg(e.getMessage());
    }
}
