package com.sg.banco.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.gumga.domain.GumgaMultitenancy;
import io.gumga.domain.shared.GumgaSharedModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.JOINED)

@Data
@EqualsAndHashCode(callSuper = true)

//@ApiModel
//@GumgaMultitenancy(enableBMO = true)
@Table(name = "person")
public class Person  extends GumgaSharedModel<Long> implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    protected Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Account> accounts;

}
