package com.example.servergraphql.domain.services;

import com.example.servergraphql.data.dao.RestaurantTablesDao;
import com.example.servergraphql.data.model.OrdersEntity;
import com.example.servergraphql.data.model.RestaurantTablesEntity;
import com.example.servergraphql.domain.model.RestaurantTables;
import com.example.servergraphql.domain.model.mappers.RestaurantTablesMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantTablesServices {

    private final RestaurantTablesDao dao;
    private final RestaurantTablesMapper mapper;
    public RestaurantTablesServices(RestaurantTablesDao dao, RestaurantTablesMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public List<RestaurantTables> getAllTablesByOrder(int idorder){
       List<RestaurantTablesEntity>  result=dao.findAllByOrdersId(idorder);
       List<RestaurantTables> tables=new ArrayList<>();
        for (RestaurantTablesEntity c:result){
            tables.add(mapper.toTables(c));
        }
        return tables;
    }
}
