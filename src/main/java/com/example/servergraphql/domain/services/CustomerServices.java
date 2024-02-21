package com.example.servergraphql.domain.services;

import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.data.dao.CustomersDao;
import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.domain.model.Customers;
import com.example.servergraphql.domain.model.graphql.CustomerInput;
import com.example.servergraphql.domain.model.mappers.CustomerMapper;
import com.example.servergraphql.spring.errors.exceptions.IdInvalidaException;
import com.example.servergraphql.spring.errors.exceptions.NotFoundElementException;
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
            if (!dao.findById(customerInput.id()).isPresent()){
                CustomersEntity cust = mapper.toCustomerEntity(customerInput);
                CustomersEntity c = dao.save(cust);
                return mapper.toCustomer(c);
            }else {
                throw new IdInvalidaException();
            }



        }catch (DataIntegrityViolationException s){
            throw new IdInvalidaException();
        }

    }

    public Boolean deleteCustomer(int idCustomer) {
        CustomersEntity entity=dao.findById(idCustomer)
                .orElseThrow(()->new NotFoundElementException(Constantes.CUSTOMER_NOT_FOUND));
        dao.delete(entity);
        return true;
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
            throw new NotFoundElementException(Constantes.CUSTOMER_NOT_FOUND);
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
