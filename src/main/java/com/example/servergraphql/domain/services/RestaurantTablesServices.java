package com.example.servergraphql.domain.services;

import com.example.servergraphql.data.dao.RestaurantTablesDao;
import com.example.servergraphql.data.model.RestaurantTablesEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTablesServices {

    private final RestaurantTablesDao dao;

    public RestaurantTablesServices(RestaurantTablesDao dao) {
        this.dao = dao;
    }

    public List<RestaurantTablesEntity> getAllTablesByOrder(int idorder){
        return dao.findAllByOrderId(idorder);
    }
}
