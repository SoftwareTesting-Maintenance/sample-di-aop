package edu.umd.enpm614.sample.aspect.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class LoggingAspect {
    @Around("within(edu.umd.enpm4.assignment2.service.*) && execution(public * do*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StringBuilder sb = new StringBuilder("Profile time for ");
        long startTime = System.nanoTime();
        Object value = joinPoint.proceed();
        sb.append(joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append(joinPoint.getSignature().getName())
                .append(" is ").append(System.nanoTime() - startTime)
                .append(" ns");
        System.out.println(sb.toString());
        return value;
    }
}
