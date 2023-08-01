package com.example.bank_bachend.DTOS;

import com.example.bank_bachend.enteties.Client;
import com.example.bank_bachend.enteties.Operations;
import com.example.bank_bachend.enums.StatusDeCompte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
public abstract class CompteBancaireDto {
    private String type;
}
