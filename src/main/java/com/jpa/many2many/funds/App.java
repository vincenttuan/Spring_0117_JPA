package com.jpa.many2many.funds;

import com.jpa.many2many.funds.service.FundsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    static FundsService service;

    static {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.jpa");
        appContext.refresh();
        service = (FundsService) appContext.getBean("fundsService");
    }

    public static void main(String[] args) throws Exception {
        
    }
    
    
}
