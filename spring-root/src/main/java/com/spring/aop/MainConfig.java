package com.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by xsls on 2019/6/10.
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true) //(proxyTargetClass = true)  /*<aop:aspectj-autoproxy/>*/
//@EnableAspectJAutoProxy(proxyTargetClass = true) //(proxyTargetClass = true)  /*<aop:aspectj-autoproxy/>*/
@ComponentScan("com.spring.aop")
public class MainConfig {

   /* @Bean
    public Calculate calculate() {
        return new TulingCalculate();
    }

    @Bean
    public TulingLogAspect tulingLogAspect() {
        return new TulingLogAspect();
    }


    @Bean
    public Calculate calculate2() {
        return new TulingCalculate();
    }*/
}
