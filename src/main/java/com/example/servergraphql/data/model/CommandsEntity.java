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
@Table(name = Constantes.COMMANDS)
public class CommandsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constantes.COMMANDID, nullable = false)
    private int id;
    @Column(name = Constantes.COMMAND_NAME)
    private String commandName;
    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = Constantes.CUSTOMER_ID)
    private CustomersEntity customersEntity;
}
