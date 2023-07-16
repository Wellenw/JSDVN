package cn.tedu.web;

import cn.tedu.pojo.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*@ControllerAdvice
@ResponseBody
注解描述的类为全局异常处理类,启动时会交给Spring管理*/
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /*@ExceptionHandler注解描述的方法为异常处理方法,注解中定义的异常类型为当前方法可以处理的异常类型*/
    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        log.error("exception msg is {}",e.getMessage());
        return new JsonResult(e);
    }
    //可以定义多个异常处理方法
}
