package com.example.servergraphql.data.model;

import com.example.servergraphql.common.Constantes;
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
@Table(name = Constantes.RESTAURANTTABLES)
public class RestaurantTablesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constantes.TABLENUMBERID,nullable = false)
    private int id;
    @Column(name = Constantes.NUMBEROFSEATS)
    private int numberOfSeats;
    @ManyToMany(mappedBy = Constantes.TABLES)
    private List<OrdersEntity> orders;
}
