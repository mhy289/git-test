package com.mhy.ssm.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ClearSpaceAdvice {

    @Pointcut("execution(* com.mhy.ssm.service.*.*(..))")
    private void pt(){}

    @Around("pt()")
    public Object clearSpace(ProceedingJoinPoint jp) throws Throwable{
        Object[] args = jp.getArgs();
        for (int i = 0; i <args.length; i++) {
            if(args[i] instanceof String){
                args[i] = args[i].toString().trim();
                System.out.println("字符串");
            }else {
                System.out.println("非字符串");
            }
        }
        return jp.proceed(args);
    }
}
