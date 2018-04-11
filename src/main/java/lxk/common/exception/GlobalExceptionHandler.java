package lxk.common.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleControllerException(HttpServletRequest request, Exception exception) {
		log.error("全局异常：", exception);
		if (exception instanceof BindingResult) {
			onBindError((BindingResult) exception);
		}
		return new ResponseEntity("系统异常，请稍后重试！", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * springMvc参数绑定异常
	 * 
	 * @param bindingResult
	 * @return
	 */
	private void onBindError(BindingResult bindingResult) {
		FieldError error = bindingResult.getFieldError();
		log.error("Controller方法参数绑定异常code:", error);
	}

}
