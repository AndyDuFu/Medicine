package com.medicine.config;

import com.medicine.exception.BusinessException;
import com.medicine.exception.ErrorCode;
import com.medicine.util.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @SuppressWarnings("rawtypes")
	@ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public JsonResult jsonErrorHandler(HttpServletRequest req, BusinessException e) throws Exception {
        ErrorCode errorCode = e.getErrorCode();
        JsonResult jsonResult = JsonResult.builder().error(errorCode.getMessage(), errorCode.getHttpStatusCode()).build();
        return jsonResult;
    }

}