package cn.com.agree.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleControllerException(HttpServletRequest request, Throwable throwable){
        HttpStatus status = getStatus(request);
        Map<String, String> result = new HashMap<>();
        result.put("status", (String.valueOf(status.value())));
        result.put("msg", throwable.getMessage());
        return new ResponseEntity(result, status);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handleControllerArithmetic(HttpServletRequest request, Throwable throwable)
    {
        HttpStatus status = getStatus(request);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error/5xx");
        mav.addObject("errorcode",status.value());
        mav.addObject("errorMsg",throwable.getMessage());
        return mav;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
