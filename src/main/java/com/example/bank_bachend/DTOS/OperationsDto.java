package com.example.bank_bachend.DTOS;

import com.example.bank_bachend.enteties.CompteBancaire;
import com.example.bank_bachend.enums.TypeOperation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
public class OperationsDto {
    private Long id;
    private Date dateOperation;
    private double montant;
    private TypeOperation type;
}
