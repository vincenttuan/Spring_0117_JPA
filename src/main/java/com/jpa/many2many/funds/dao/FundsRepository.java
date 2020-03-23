package com.jpa.many2many.funds.dao;

import com.jpa.many2many.funds.entity.Fund;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface FundsRepository extends CrudRepository<Fund, Integer>{
    
}
