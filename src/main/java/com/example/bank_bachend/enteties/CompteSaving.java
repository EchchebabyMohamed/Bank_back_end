package com.example.bank_bachend.enteties;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@DiscriminatorValue("SAV")
@Data @NoArgsConstructor @AllArgsConstructor
public class CompteSaving extends CompteBancaire{
    private double tauxDinteret;
}
