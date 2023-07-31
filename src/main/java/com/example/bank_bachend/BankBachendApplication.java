package com.example.bank_bachend;

import com.example.bank_bachend.DTOS.ClientDto;
import com.example.bank_bachend.Exeptions.ClientNontrouverExeption;
import com.example.bank_bachend.Exeptions.CompteBancaireNotFoundException;
import com.example.bank_bachend.Exeptions.SoldeNonSuffisantException;
import com.example.bank_bachend.Service.CompteBancaireService;
import com.example.bank_bachend.enteties.Client;
import com.example.bank_bachend.enteties.CompteCourant;
import com.example.bank_bachend.enteties.CompteSaving;
import com.example.bank_bachend.enteties.Operations;
import com.example.bank_bachend.enums.StatusDeCompte;
import com.example.bank_bachend.enums.TypeOperation;
import com.example.bank_bachend.reposetory.BnakReposetory;
import com.example.bank_bachend.reposetory.ClientReposetory;
import com.example.bank_bachend.reposetory.OperationsReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.rmi.server.UID;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankBachendApplication implements CommandLineRunner {
    @Autowired
    CompteBancaireService compteBancaireService;
    public static void main(String[] args) {
        SpringApplication.run(BankBachendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("hassan","imane","mohamed").forEach(name->{
            ClientDto client = new ClientDto();
            client.setNom(name);
            client.setEmai(name+"@gamil.com");
            compteBancaireService.ajoutClient(client);
        });
        compteBancaireService.listeClient().forEach(cl->{
            try {
                compteBancaireService.ajouterCompteBancaireCourant(Math.random()*90000,6000, cl.getId());
                compteBancaireService.ajouterCompteBancaireSaving(Math.random()*5000,5.5, cl.getId());
                compteBancaireService.getComptes().forEach(cmpt->{
                    for (int i = 0; i < 10; i++) {
                        try {
                            compteBancaireService.versement(cmpt.getId(),Math.random()*10000,"versement");
                            compteBancaireService.retrait(cmpt.getId(),1000+Math.random(),"retrait");
                        } catch (CompteBancaireNotFoundException | SoldeNonSuffisantException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            } catch (ClientNontrouverExeption e) {
                throw new RuntimeException(e);
            }
        });

    }
}
