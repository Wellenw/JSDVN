package cn.tedu.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Aspect 描述类型为切面类型，通常定义两个部分：
 * 1）切入点：切入拓展功能的点
 * 2）通知：要织入的功能
* */
@Aspect
@Slf4j
@Component
public class SysLogAspect {

    @Pointcut("bean(productController)")
    public void logPointCut(){}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        long t1 = System.currentTimeMillis();
        try {
            Object result = jp.proceed();
            long t2=System.currentTimeMillis();
            log.info("method execute time {}",(t2-t1));
            return result;
        } catch (Throwable e) {
            log.error("error is {} ",e.getMessage());
            throw e;
        }
    }
}
