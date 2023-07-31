package com.example.bank_bachend.Exeptions;

public class CompteBancaireNotFoundException extends Exception {
    public CompteBancaireNotFoundException(String compteBancaireNonTrouver) {
        super(compteBancaireNonTrouver);
    }
}
