package com.example.servergraphql.data.dao;

import com.example.servergraphql.data.model.Credentials;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsDao extends ListCrudRepository<Credentials,Long> {
}
