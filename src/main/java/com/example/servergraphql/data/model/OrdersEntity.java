package com.example.servergraphql.data.model;

import com.example.servergraphql.common.Constantes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Constantes.ORDERS)
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constantes.ID, nullable = false)
    private int orderId;
    @Column(name = Constantes.ORDERDATE)
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = Constantes.CUSTOMERID)
    private CustomersEntity customersEntity;
    @OneToMany(mappedBy = Constantes.ORDER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<OrderItemsEntity> orderItemEntities;


    public OrdersEntity(int orderId) {
        this.orderId = orderId;
    }
}
