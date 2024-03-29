package com.example.servergraphql.data.dao;

import com.example.servergraphql.data.model.CustomersEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomersDao extends ListCrudRepository<CustomersEntity,Long> {


    Optional<CustomersEntity> findById(int id);
}
