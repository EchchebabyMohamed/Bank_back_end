package com.example.bank_bachend.enteties;

import com.example.bank_bachend.enums.StatusDeCompte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",length = 4,discriminatorType = DiscriminatorType.STRING)
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class CompteBancaire {
    @Id
    private String id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    private StatusDeCompte statusDeCompte;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "compteBancaire")
    private List<Operations> operations;
}
