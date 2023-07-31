package com.example.bank_bachend.Exeptions;

public class SoldeNonSuffisantException extends Exception {
    public SoldeNonSuffisantException(String soldeNonSuffisant) {
        super(soldeNonSuffisant);
    }
}
