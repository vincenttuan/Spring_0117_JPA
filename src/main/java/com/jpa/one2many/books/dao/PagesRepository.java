package com.jpa.one2many.books.dao;

import com.jpa.one2many.books.entity.Page;
import org.springframework.data.repository.CrudRepository;

public interface PagesRepository extends CrudRepository<Page, Long>{
    
}
