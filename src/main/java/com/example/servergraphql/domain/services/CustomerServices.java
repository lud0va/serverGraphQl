package com.example.servergraphql.domain.services;

import com.example.servergraphql.data.dao.CustomersDao;
import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.domain.model.Customers;
import com.example.servergraphql.domain.model.graphql.CustomerInput;
import com.example.servergraphql.domain.model.mappers.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {

    private  final CustomerMapper mapper;
    private final CustomersDao dao;


    public CustomerServices(CustomerMapper mapper, CustomersDao dao) {
        this.mapper = mapper;

        this.dao = dao;
    }
    public List<Customers> getAll(){
        List<CustomersEntity> c= dao.findAll();
        List<Customers>s=new ArrayList<>();
        for (CustomersEntity e:c){
            s.add(mapper.toCustomer(e));
        }

        return s;
    }

    public Customers getById(int id) {
        CustomersEntity c = null;
        Optional<CustomersEntity> result = dao.findById(id);
        if (result.isPresent()) {
            c = result.get();

        }
        return mapper.toCustomer(c);
    }


    public Customers saveCustomer(CustomerInput customer){
        CustomersEntity cust=mapper.toCustomerEntity(customer);
       CustomersEntity c= dao.save(cust);

        return mapper.toCustomer(c);
    }
}
