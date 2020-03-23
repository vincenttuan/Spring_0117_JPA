package com.jpa.many2many.funds.dao;

import com.jpa.many2many.funds.entity.Fund;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface FundsRepository extends CrudRepository<Fund, Integer>{
    @Transactional
    @Modifying
    //@Query(value = "DELETE FROM fund_stock WHERE fund_id=? AND stock_id=?", nativeQuery = true)
    @Query(value = "DELETE FROM fund_stock WHERE fund_id=?1 AND stock_id=?2", nativeQuery = true)
    public void removeStock(int fund_id, int stock_id);
}
