package com.example.servergraphql.data.model;

import com.example.servergraphql.common.Constantes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Constantes.CUSTOMERS)
public class CustomersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constantes.ID, nullable = false)
    private int id;
    @Column(name = Constantes.FIRSTNAME)
    private String firstName;
    @Column(name = Constantes.LASTNAME)
    private String lastName;
    @Column(name = Constantes.EMAIL)
    private String email;
    @Column(name = Constantes.PHONE)
    private String phone;
    @Column(name = Constantes.DATEOFBIRTH)
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = Constantes.CUSTOMERS_ENTITY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<OrdersEntity> orders;
    public CustomersEntity(String firstName, String lastName, String email, String phone, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    public CustomersEntity(int id) {
        this.id = id;
    }
}
