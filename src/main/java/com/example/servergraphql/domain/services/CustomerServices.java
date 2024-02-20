package com.example.servergraphql.domain.services;

import com.example.servergraphql.data.dao.CustomersDao;
import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.domain.model.Customers;
import com.example.servergraphql.domain.model.graphql.CustomerInput;
import com.example.servergraphql.domain.model.mappers.CustomerMapper;
import com.example.servergraphql.spring.Errors.exceptions.IdInvalidaException;
import com.example.servergraphql.spring.Errors.exceptions.NotFoundElementException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerServices {

    private final CustomerMapper mapper;
    private final CustomersDao dao;


    public CustomerServices(CustomerMapper mapper, CustomersDao dao) {
        this.mapper = mapper;

        this.dao = dao;
    }

    public List<Customers> getAll() {
        List<CustomersEntity> c = dao.findAll();
        List<Customers> s = new ArrayList<>();
        for (CustomersEntity e : c) {
            s.add(mapper.toCustomer(e));
        }

        return s;
    }

    public Customers updateCustomer(CustomerInput customerInput){
        try {
            CustomersEntity cust = mapper.toCustomerEntity(customerInput);
            CustomersEntity c = dao.save(cust);

            return mapper.toCustomer(c);
        }catch (DataIntegrityViolationException s){
            throw new IdInvalidaException();
        }

    }

    public void deleteCustomer(int idCustomer) {
        CustomersEntity entity=dao.findById(idCustomer).get();
        dao.delete(entity);

    }

    public Customers getById(int id) {
        try {
            CustomersEntity c = null;
            Optional<CustomersEntity> result = dao.findById(id);
            if (result.isPresent()) {
                c = result.get();

            }
            return mapper.toCustomer(c);

        }catch (NoSuchElementException s){
            throw new NotFoundElementException("Customer not found");
        }



    }


    public Customers saveCustomer(CustomerInput customer) {
        try {
            CustomersEntity cust = mapper.toCustomerEntity(customer);
            CustomersEntity c = dao.save(cust);

            return mapper.toCustomer(c);
        }catch (DataIntegrityViolationException s){
            throw new IdInvalidaException();
        }

    }
}
