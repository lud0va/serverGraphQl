package com.example.servergraphql.domain.services;

import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.data.dao.RestaurantTablesDao;
import com.example.servergraphql.data.model.RestaurantTablesEntity;
import com.example.servergraphql.domain.model.RestaurantTables;
import com.example.servergraphql.domain.model.mappers.RestaurantTablesMapper;
import com.example.servergraphql.spring.errors.exceptions.NotFoundElementException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RestaurantTablesServices {

    private final RestaurantTablesDao dao;
    private final RestaurantTablesMapper mapper;
    public RestaurantTablesServices(RestaurantTablesDao dao, RestaurantTablesMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public List<RestaurantTables> getAllTablesByCustomer(int idCust){
        try {
            List<RestaurantTablesEntity>  result=dao.findAllByCustomersId(idCust);
            List<RestaurantTables> tables=new ArrayList<>();
            for (RestaurantTablesEntity c:result){
                tables.add(mapper.toTables(c));
            }
            return tables;
        }catch (NoSuchElementException s){
            throw new NotFoundElementException(Constantes.MESA_NO_ENCONTRADA);
        }

    }
}
