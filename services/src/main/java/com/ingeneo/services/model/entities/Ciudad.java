package com.ingeneo.services.model.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TBL_CIUDAD")
@Entity
@Getter
public class Ciudad {
    @Id
    @Column(name = "ID_CIUDAD")
    private Integer id;

    @Column(name = "NOMBRE_CIUDAD")
    private String name;
}
