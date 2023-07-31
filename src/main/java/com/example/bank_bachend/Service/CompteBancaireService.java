package com.example.bank_bachend.Service;

import com.example.bank_bachend.DTOS.ClientDto;
import com.example.bank_bachend.Exeptions.ClientNontrouverExeption;
import com.example.bank_bachend.Exeptions.CompteBancaireNotFoundException;
import com.example.bank_bachend.Exeptions.SoldeNonSuffisantException;
import com.example.bank_bachend.enteties.Client;
import com.example.bank_bachend.enteties.CompteBancaire;
import com.example.bank_bachend.enteties.CompteCourant;
import com.example.bank_bachend.enteties.CompteSaving;

import java.util.List;

public interface CompteBancaireService {
    ClientDto ajoutClient(ClientDto clientDto);

    CompteCourant ajouterCompteBancaireCourant(double soldeInitial, double decouvert, Long idClient) throws ClientNontrouverExeption;
    CompteSaving ajouterCompteBancaireSaving(double soldeInitial, double tauxDinteret, Long idClient) throws ClientNontrouverExeption;
    List<ClientDto> listeClient();
    CompteBancaire getCompte(String idCompte) throws CompteBancaireNotFoundException;
    void versement(String idCompte, double montant,String description) throws CompteBancaireNotFoundException;
    void retrait(String idCompte, double montant,String description) throws CompteBancaireNotFoundException, SoldeNonSuffisantException;
    void virement(String idCompteSource,String idCompteDestination, double montant) throws SoldeNonSuffisantException, CompteBancaireNotFoundException;

    List<CompteBancaire> getComptes();
    ClientDto getClient(Long id) throws ClientNontrouverExeption;

    ClientDto misAJourClient(ClientDto clientDto);

    void supprimerClient(Long id);
}
