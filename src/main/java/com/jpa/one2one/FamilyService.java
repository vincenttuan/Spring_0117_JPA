package com.jpa.one2one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("familyService")
public class FamilyService {
    @Autowired
    private HusbandRepository hr;
    
    @Autowired
    private WifeRepository wr;
    
    public void save(Husband husband) {
        hr.save(husband);
        System.out.println("Hasband save OK !");
    }
    
    public Husband findHusbandById(Long id) {
        return hr.findById(id).get();
    }
    
    public Wife findWifeById(Long id) {
        return wr.findById(id).get();
    }
    
}
