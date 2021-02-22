package com.ingeneo.services.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "TBL_SALAS")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "FILAS")
    private Integer rows;

    @Column(name = "ID_FORMATO")
    private Integer idFormat;

    @Column(name = "ID_SUCURSAL")
    private Integer idBranch;
}
