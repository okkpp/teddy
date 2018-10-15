package okkpp.common.base;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import okkpp.common.result.Result;

@Component
public class BaseController {

	protected Result<String> result(boolean result){
		if(result) {
			return successMsg("请求成功");
		}
		return faildMsg("请求失败");
	}
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
		return faildMsg(e.getMessage());
    }
}
