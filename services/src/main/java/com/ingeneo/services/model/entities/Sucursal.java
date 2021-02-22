package com.ingeneo.services.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TBL_SUCURSAL")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {
    @Id
    @Column(name = "ID_SUCURSAL")
    private Integer id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "DIRECCION")
    private String address;

    @Column(name = "ID_DIRECTOR")
    private Integer idManager;

    @Column(name = "ID_CIUDAD")
    private Integer ciudad;

    @Column(name = "COMENTARIO")
    private String comment;
}
