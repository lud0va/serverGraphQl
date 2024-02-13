package com.example.servergraphql.data.model;

import com.example.servergraphql.common.Constantes;
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
@Table(name = Constantes.ORDERITEMS)
public class OrderItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constantes.ORDERITEMID, nullable = false)
    private int orderItemId;

   @Column(name = Constantes.NAME)
    private String name;
   @Column(name = Constantes.PRICE)
    private double price;
   @Column(name = Constantes.QUANTITY)
    private int quantity;

    @ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(name = Constantes.ORDER_ID)
    private OrdersEntity order;

}
