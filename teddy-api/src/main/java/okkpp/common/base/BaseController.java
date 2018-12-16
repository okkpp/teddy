package okkpp.common.base;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;

import okkpp.common.result.Result;
import okkpp.model.User;

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
	
	protected <T> T transfer(Object source, Class<T> target) {
		T instance = null;
		try {
			instance = target.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		Assert.notNull(instance, "transfer异常");
		BeanUtils.copyProperties(source, instance);
		return instance;
	}
	
	/**
	 * 获取登录信息
	 */
	protected User getSubject() {
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		Assert.notNull(user, "用户未登录！");
		return user;
	}
	
	@ExceptionHandler(value = Exception.class)
    public Result<String> baseExceptionHandler(Exception e) {
		return faildMsg(e.getMessage());
    }
}
