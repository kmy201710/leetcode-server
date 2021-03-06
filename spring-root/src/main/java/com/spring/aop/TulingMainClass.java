package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xsls on 2019/6/10.
 */
public class TulingMainClass {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

        Calculate calculate = (Calculate) ctx.getBean("tulingCalculate");
        int retVal = calculate.add(2, 4);

        /*ProgramCalculate calculate = (ProgramCalculate) ctx.getBean("tulingCalculate");
        System.out.println(calculate.toBinary(100));*/
        System.out.println("retVal = " + retVal);
    }
}
