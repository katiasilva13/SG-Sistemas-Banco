package com.sg.banco.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "natural_person_id")
@Entity
public class NaturalPerson extends Person {

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String rg;

}
