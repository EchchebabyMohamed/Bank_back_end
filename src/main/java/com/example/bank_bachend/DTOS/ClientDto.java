package com.example.bank_bachend.DTOS;

import com.example.bank_bachend.enteties.CompteBancaire;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class ClientDto {
    private Long id;
    private String nom;
    private String Emai;
    //private String tel;
}
