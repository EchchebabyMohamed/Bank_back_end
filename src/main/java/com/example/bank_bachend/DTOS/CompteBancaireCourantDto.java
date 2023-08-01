package com.example.bank_bachend.DTOS;

import com.example.bank_bachend.enums.StatusDeCompte;
import lombok.Data;

import java.util.Date;

@Data
public class CompteBancaireCourantDto extends  CompteBancaireDto{
    private String id;
    private double solde;
    private Date dateCreation;
    private StatusDeCompte statusDeCompte;
    private ClientDto clientDto;
    private double decouvert;
}
