package com.jpa.many2many.funds;

import com.jpa.many2many.funds.entity.Fund;
import com.jpa.many2many.funds.entity.Stock;
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
        remove();
    }
    
    public static void remove() {
        Fund fund = service.getFundsRepository().findById(2).get();
        Stock stock = service.getStocksRepository().findById(2).get();
        int fund_id = fund.getId();
        int stock_id = stock.getId();
        service.getFundsRepository().removeStock(fund_id, stock_id);
    }
    
    public static void update() {
        Fund fund = service.getFundsRepository().findById(2).get();
        Stock stock = service.getStocksRepository().findById(2).get();
        fund.getStocks().add(stock);
        service.getFundsRepository().save(fund);
    }
    
    public static void save() {
        Stock stock1 = new Stock("2330.TW");
        Stock stock2 = new Stock("1101.TW");
        service.getStocksRepository().save(stock1);
        service.getStocksRepository().save(stock2);
        
        Fund fund_a = new Fund("A");
        fund_a.getStocks().add(stock1);
        fund_a.getStocks().add(stock2);
        
        Fund fund_b = new Fund("B");
        fund_b.getStocks().add(stock1);
        
        service.getFundsRepository().save(fund_a);
        service.getFundsRepository().save(fund_b);
    }
    
}
