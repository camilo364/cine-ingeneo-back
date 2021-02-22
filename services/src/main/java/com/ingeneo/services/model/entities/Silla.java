package com.ingeneo.services.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "TBL_SILLAS")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Silla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SILLA")
    private Integer id;

    @Column(name = "ID_SALA")
    private Integer idRoom;

    @Column(name = "LETRA")
    private String letter;

    @Column(name = "NUMERO")
    private Integer number;

    @Column(name = "ESTADO")
    private String status;
}
