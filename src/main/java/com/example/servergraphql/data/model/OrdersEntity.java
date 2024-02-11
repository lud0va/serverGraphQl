package com.example.servergraphql.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int orderId;
    @Column(name = "order_date")
    private LocalDateTime order_date;
    @ManyToOne
    @JoinColumn(name ="customer_id" )
    private CustomersEntity customersEntity;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<OrderItemsEntity> orderItemEntities;
    @ManyToMany
    @JoinTable(
            name = "table_orders_mapping",
            joinColumns =  @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name = "table_number_id")
    )
    private Set<RestaurantTablesEntity> tables;

    public OrdersEntity(int orderId) {
        this.orderId = orderId;
    }
}
