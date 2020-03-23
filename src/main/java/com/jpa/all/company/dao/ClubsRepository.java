package com.jpa.all.company.dao;

import com.jpa.all.company.entity.Club;
import org.springframework.data.repository.CrudRepository;

public interface ClubsRepository extends CrudRepository<Club, Integer>{
    
}
