package com.jpa.many2many.funds.service;

import com.jpa.many2many.funds.dao.FundsRepository;
import com.jpa.many2many.funds.dao.StocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fundsService")
public class FundsService {
    
    @Autowired
    private FundsRepository fundsRepository;
    
    @Autowired
    private StocksRepository stocksRepository;

    public FundsRepository getFundsRepository() {
        return fundsRepository;
    }

    public StocksRepository getStocksRepository() {
        return stocksRepository;
    }
    
    
}
