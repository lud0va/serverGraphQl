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
@Table(name = "commands")
public class CommandsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commandId", nullable = false)
    private int id;
    @Column(name = "commandName")
    private String commandName;
    @JoinColumn(name ="customerId" )
    private int customerId;
}
