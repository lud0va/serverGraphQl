package com.example.servergraphql.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant_tables")
public class RestaurantTablesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_number_id",nullable = false)
    private int id;
    @Column(name = "number_of_seats")
    private int numberOfSeats;
    @ManyToMany(mappedBy = "tables")
    private List<OrdersEntity> orders;
}
