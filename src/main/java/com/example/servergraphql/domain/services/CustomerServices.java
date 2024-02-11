package com.example.servergraphql.domain.services;

import com.example.servergraphql.data.dao.CustomersDao;
import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.domain.model.graphql.CustomerInput;
import com.example.servergraphql.domain.model.mappers.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {

    private  final CustomerMapper mapper;
    private final CustomersDao dao;


    public CustomerServices(CustomerMapper mapper, CustomersDao dao) {
        this.mapper = mapper;

        this.dao = dao;
    }
    public List<CustomersEntity> getAll(){
        return dao.findAll();
    }

    public CustomersEntity getById(int id){return dao.findById(Long.valueOf(id)).get();}
    public CustomersEntity saveCustomer(CustomerInput customer){
        CustomersEntity cust=mapper.toCustomerEntity(customer);
        return dao.save(cust);
    }
}
