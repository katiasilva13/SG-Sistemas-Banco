package com.sg.banco.domain.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name = "natural_person_id")
@Entity(name="natural_person")
public class NaturalPerson extends Person {

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String rg;

}
