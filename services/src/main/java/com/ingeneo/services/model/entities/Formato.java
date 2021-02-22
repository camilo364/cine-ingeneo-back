package com.ingeneo.services.model.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TBL_FORMATO")
@Entity
@Getter
public class Formato {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FORMATO")
    private String name;

    @Column(name = "COMENTARIO")
    private String comment;
}
