package top.kangyong.study01.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 日志拦截器
 * @author: kangyong
 * @date: 2019/12/18 20:30
 * @version: v1.0
 */
public class LogAdvice {

    /**
     * 执行方法前拦截
     */
    public void methodBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + " Start");
    }

    /**
     * 方法执行后拦截器
     *
     * @param joinPoint
     */
    public void methodAfter(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + " End");
    }

    /**
     * 方法出现异常拦截器
     *
     * @param joinPoint
     */
    public void methodException(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + " mett Error");
    }

    /**
     * 方法环绕拦截器
     *
     * @return
     */
    public Object methodRound(ProceedingJoinPoint joinPoint) {
        methodBefore(joinPoint);
        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable error) {
            methodException(joinPoint);
        }
        methodAfter(joinPoint);
        return o;
    }

}
