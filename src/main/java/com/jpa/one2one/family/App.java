package com.jpa.one2one.family;

import com.jpa.one2one.family.service.FamilyService;
import com.jpa.one2one.family.entity.Wife;
import com.jpa.one2one.family.entity.Husband;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
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
        //findWifeById(2L);
    }
    
    public static void findHusbandById(Long id) throws Exception {
        Husband husband = service.getHusbandRepository().findById(id).get();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(husband);
        System.out.println(json);
    }
    
    public static void save() {
        Wife wife = new Wife();
        wife.setName("Angle");
        Husband husband = new Husband();
        husband.setName("Eve");
        husband.setWife(wife);
        service.getHusbandRepository().save(husband);
    }
    
    
}
