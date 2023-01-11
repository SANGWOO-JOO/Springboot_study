package hello.aop.order;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;


@Slf4j
public class AspectV5Order {
//    //hello.aop.order 패키지와 하위 패키지
//    @Pointcut("execution(* hello.aop.order..*(..))") //pointcut expression
//    private void allOrder(){} //pointcut signature
//
//    //클래스 이름 패턴이 *Service
//    @Pointcut("execution(* *..*Service.*(..))")
//    private void allService(){}

    //hello.aop.order 패키지와 하위 패키지

    @Aspect
    @Order(2)
    public static class LogAspect{
        @Around("hello.aop.order.Pointcuts.allOrder()")
        public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[log] {}", joinPoint.getSignature()); //join point 시그니처
            return joinPoint.proceed();
        }
    }

    @Aspect
    @Order(1)
    public static class TxAspect{
        //hello.aop.order 패키지와 하위 패키지 이면서 클래스 이름이 패턴이 *Service
        @Around("hello.aop.order.Pointcuts.orderAndService()")
        public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable
        {
            try{
                log.info("[트랙잭션 시작] {}", joinPoint.getSignature());
                Object result =joinPoint.proceed();
                log.info("[트랙잭션 커밋] {}", joinPoint.getSignature());
                return result;
            }catch (Exception e){
                log.info("[트랙잭션 롤백] {}", joinPoint.getSignature());
                throw e;
            }
            finally {
                log.info("[리소스 릴리즈] {}", joinPoint.getSignature());
            }
        }
    }
}
