package hello.aop.order;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;


@Slf4j
@Aspect
public class AspectV4Pointcut {
     /*
   `     사용하는 방법은 패키지명을 포함한 클래스 이름과 포인트컷 시그니처를 모두 지정하면 된다.
         포인트컷을 여러 어드바이스에서 함께 사용할 때 이 방법을 사용하면 효과적이다.
     */
    @Around("hello.aop.order.Pointcuts.allOrder()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature()); //join point 시그니처
        return joinPoint.proceed();
    }
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
