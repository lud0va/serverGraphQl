package com.example.servergraphql.data.dao;

import com.example.servergraphql.data.model.CommandsEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandsDao extends ListCrudRepository<CommandsEntity,Long> {
    Optional<List<CommandsEntity>> findAllByCustomerId(int aLong);
}
