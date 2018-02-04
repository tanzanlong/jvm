package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	@org.junit.Test
    public void testHelloworld() {  
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("/application.xml");  
        IHelloWorldService helloworldService =  
        ctx.getBean("helloWorldService", IHelloWorldService.class);  
        helloworldService.sayHello();  
    }  
}
