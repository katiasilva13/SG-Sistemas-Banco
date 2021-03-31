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
@PrimaryKeyJoinColumn(name = "legal_person_id")
@Entity
public class LegalPerson extends Person {

    @Column(name = "cnpj")
    private String cnpj;
}
