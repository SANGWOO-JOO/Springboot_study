package hello.aop;

import hello.aop.order.*;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;



//@Import(AspectV4Pointcut.class) // Bean같이 쓸 수 있음
//@Import({AspectV5Order.LogAspect.class, AspectV5Order.LogAspect.class})
@Slf4j
@SpringBootTest
@Import(AspectV1.class)
//@Import({AspectV5Order.LogAspect.class, AspectV5Order.TxAspect.class})
//@Import(AspectV6Advice.class)
public class AopTest {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    void aopInfo() {
        log.info("isAopProxy, orderService={}",
                AopUtils.isAopProxy(orderService)); //AOP 프록시 적용됐는지 확인
        log.info("isAopProxy, orderRepository={}",
                AopUtils.isAopProxy(orderRepository)); //AOP 프록시 적용됐는지 확인
    }

    @Test
    void success(){
        orderService.orderItem("ItemA");
    }

    @Test
    void exception() {
        Assertions.assertThatThrownBy(() -> orderService.orderItem("ex"))
                .isInstanceOf(IllegalStateException.class); //예외 터지는 코드
    }
}