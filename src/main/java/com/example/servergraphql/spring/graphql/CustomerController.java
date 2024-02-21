package com.example.servergraphql.spring.graphql;


import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.domain.model.Customers;
import com.example.servergraphql.domain.model.graphql.CustomerInput;
import com.example.servergraphql.domain.services.CustomerServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerServices customerServices;

    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @MutationMapping
    @PreAuthorize(Constantes.HAS_ROLE_ADMIN)
    public Customers updateCustomer(@Argument CustomerInput input) {
     return customerServices.updateCustomer(input);
    }

    @MutationMapping
    @PreAuthorize(Constantes.HAS_ROLE_ADMIN)
    public Boolean deleteCustomer(@Argument int idCustomer) {

        return customerServices.deleteCustomer(idCustomer);
    }
    @QueryMapping
    @PreAuthorize(Constantes.HAS_ROLE_ADMIN_OR_HAS_ROLE_USER)
    public List<Customers> getCustomers() {
        return customerServices.getAll();
    }

    @QueryMapping
    @PreAuthorize(Constantes.HAS_ROLE_ADMIN_OR_HAS_ROLE_USER)
    public Customers getCustomer(@Argument int id) {
        return customerServices.getById(id);
    }

    @MutationMapping
    @PreAuthorize(Constantes.HAS_ROLE_ADMIN)
    public Customers addCustomer(@Argument CustomerInput input) {
        return customerServices.saveCustomer(input);
    }


}
