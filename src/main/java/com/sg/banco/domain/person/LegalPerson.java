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
@PrimaryKeyJoinColumn(name = "legal_person_id")
@Entity(name="legal_person")
public class LegalPerson extends Person {

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "company_name")
    private String companyName;

}