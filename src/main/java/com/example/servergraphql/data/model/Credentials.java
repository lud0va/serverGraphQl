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
@Table(name = Constantes.CREDENTIALS)
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constantes.IDCREDENTIALS, nullable = false)
    private int id;
    @Column(name = Constantes.USERNAME)
    private String userName;
    @Column(name = Constantes.PASSWORD)
    private String password;
    @Column(name = Constantes.ROL)
    private String rol;


}
