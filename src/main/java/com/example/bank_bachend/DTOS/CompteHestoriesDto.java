package com.example.bank_bachend.DTOS;

import lombok.Data;

import java.util.List;
@Data
public class CompteHestoriesDto {
    private String idcompt;
    private double solde;
    private int page_;
    private int totalePages;
    private int sizeDepage;
    List<OperationsDto> operationsDtos;
}
