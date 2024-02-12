package com.example.servergraphql.spring.graphql;

import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.domain.model.Customers;
import com.example.servergraphql.domain.model.graphql.CustomerInput;
import com.example.servergraphql.domain.services.CustomerServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerServices customerServices;

    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @QueryMapping
    public List<Customers> getCustomers() {
        return customerServices.getAll();
    }
    @QueryMapping
    public Customers getCustomer(@Argument int id){
        return customerServices.getById(id);
    }
    @MutationMapping
    public Customers addCustomer(@Argument CustomerInput input){return customerServices.saveCustomer(input);}


}
