package com.jpa.one2one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("familyService")
public class FamilyService {
    @Autowired
    private HusbandRepository husbandRepository;
    
    @Autowired
    private WifeRepository wifeRepository;

    public HusbandRepository getHusbandRepository() {
        return husbandRepository;
    }

    public WifeRepository getWifeRepository() {
        return wifeRepository;
    }
    
    
    
}
