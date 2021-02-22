package com.ingeneo.services.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TBL_REGLAS")
@Entity
@Getter
public class Regla {
    @Id
    @Column(name = "ID_REGLA")
    private Integer id;

    @Column(name = "PROCESO_NEGOCIO")
    private String process;

    @Column(name = "NOMBRE_REGLA")
    private String rule;

    @Column(name = "VALOR_REGLA")
    private String value;
}
