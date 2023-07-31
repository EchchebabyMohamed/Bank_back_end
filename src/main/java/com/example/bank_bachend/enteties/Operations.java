package com.example.bank_bachend.enteties;

import com.example.bank_bachend.enums.TypeOperation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Operations {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateOperation;
    private double montant;
    @Enumerated(EnumType.STRING)
    private TypeOperation type;
    @ManyToOne
    private CompteBancaire compteBancaire;

}
