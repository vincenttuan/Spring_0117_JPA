package com.jpa.one2one;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Family_CRUD {
    static FamilyService service;
    static {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.jpa");
        appContext.refresh();
        service = (FamilyService) appContext.getBean("familyService");
    }
    public static void main(String[] args) throws Exception {
        //save();
        findHusbandById(1L);
        findWifeById(2L);
    }
    
    public static void findHusbandById(Long id) throws Exception {
        Husband husband = service.findHusbandById(id);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(husband);
        System.out.println(json);
    }
    
    public static void findWifeById(Long id) throws Exception {
        Wife wife = service.findWifeById(id);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(wife);
        System.out.println(json);
    }
    
    public static void save() {
        Wife wife = new Wife();
        wife.setName("Angle");
        Husband husband = new Husband();
        husband.setName("Eve");
        husband.setWife(wife);
        service.save(husband);
    }
    
    
}
