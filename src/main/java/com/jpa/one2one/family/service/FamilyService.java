package com.jpa.one2one.family.service;

import com.jpa.one2one.family.dao.WifeRepository;
import com.jpa.one2one.family.dao.HusbandRepository;
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
