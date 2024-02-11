package com.example.servergraphql.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", nullable = false)
    private int orderItemId;

   @Column(name = "name")
    private String name;
   @Column(name = "price")
    private double price;
   @Column(name = "quantity")
    private int quantity;

    @ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(name = "order_id")
    private OrdersEntity order;

    public OrderItemsEntity(int orderItemId) {
        this.orderItemId = orderItemId;
    }
}
