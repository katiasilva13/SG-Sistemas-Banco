package com.sg.banco.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sg.banco.enumerator.UF;
import io.gumga.domain.shared.GumgaSharedModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity

@Data
@EqualsAndHashCode(callSuper = true)

//@ApiModel
//@GumgaMultitenancy(enableBMO = true)
@Table(name = "address")
public class Address extends GumgaSharedModel<Long> implements Serializable  {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    protected Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "city")
    private String city;

    @Column(name = "cep")
    private String cep;

    @Column
    @Enumerated(EnumType.STRING)
    private UF uf;

}
