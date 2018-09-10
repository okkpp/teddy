package okkpp.common.base;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import okkpp.common.result.Result;

@Component
public class BaseController {

	protected Result<String> successMsg(String msg){
		return new Result<>(msg);
	}
	protected Result<String> faildMsg(String msg){
		return new Result<>(-200, msg);
	}
	protected <T> Result<T> successData(T data){
		return new Result<>(data);
	}
	@ExceptionHandler(value = Exception.class)
    public Result<String> baseExceptionHandler(Exception e) {
//        logger.error("error msg = {}", e);
		Result<String> result = faildMsg(e.getMessage());
		return result;
//        ResultDto<String> resultDto = new ResultDto<String>();
//        if (e instanceof BaseException) {
//            resultDto.setResultCodeInfo((BaseException) e);
//        } else if (e instanceof MethodArgumentNotValidException) {
//            resultDto.setResultCode(ResultCodeInfo.E300005.getResultCode());
//            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
//            List<ObjectError> errors = bindingResult.getAllErrors();
//            if (!CollectionUtils.isEmpty(errors) && null != errors.get(0) && !StringUtils.isEmpty(errors.get(0).getDefaultMessage())) {
//                resultDto.setErrorMsg(errors.get(0).getDefaultMessage());
//            } else {
//                resultDto.setErrorMsg("参数校验出错");
//            }
//        } else {
//            resultDto.setResultCodeInfo(ResultCodeInfo.E999999);
//        }
//        return resultDto;
    }
}
