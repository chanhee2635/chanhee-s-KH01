package edu.kh.project.common.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {
   
   // Logger : 로그를 작성할 수 있게하는 객체
   private Logger logger = LoggerFactory.getLogger(AroundAspect.class);
   
   // 전처리, 후처리를 모두 해결하고자 할 때 사용 하는 어드바이스
   // proceed() 메소드 호출 전  : @Before advice 작성
   // proceed() 메소드 호출 후  : @After advice 작성
   // 메소드 마지막에 proceed()의 반환값을 리턴해야함. 
   @Order(2) 
   @Around("CommonPointcut.serviceImplPointcut()")
   public Object aroundServiceLogs(ProceedingJoinPoint pp) throws Throwable {
      // @Around advice는 JoinPoint Interface가 아닌
      //  하위 타입인 ProceedingJoinPoint를 사용해야 함.
      // 반드시 Object 반환
      
      long startMs = System.currentTimeMillis(); // 서비스 시작 시의 ms 값
      
      Object obj = pp.proceed(); // 여기가 기준(before, after 나눠짐)
      
      long endMs = System.currentTimeMillis(); // 서비스 종료 시의 ms 값
      
      String str = "Running Time : " + (endMs- startMs) + "ms";  // 수행에 걸린 시간

      logger.info(str);
      
      return obj;
      
   }
   
}

