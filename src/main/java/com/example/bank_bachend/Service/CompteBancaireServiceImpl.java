package com.example.bank_bachend.Service;

import com.example.bank_bachend.DTOS.ClientDto;
import com.example.bank_bachend.Exeptions.ClientNontrouverExeption;
import com.example.bank_bachend.Exeptions.CompteBancaireNotFoundException;
import com.example.bank_bachend.Exeptions.SoldeNonSuffisantException;
import com.example.bank_bachend.Mapers.CompteBancaireMapperImpl;
import com.example.bank_bachend.enteties.*;
import com.example.bank_bachend.enums.TypeOperation;
import com.example.bank_bachend.reposetory.BnakReposetory;
import com.example.bank_bachend.reposetory.ClientReposetory;
import com.example.bank_bachend.reposetory.OperationsReposetory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor //constructeur avec paramètres
@Slf4j //pour la journalisation via lombok
public class CompteBancaireServiceImpl implements CompteBancaireService{
    ClientReposetory clientReposetory;
    BnakReposetory bnakReposetory;
    CompteBancaireMapperImpl compteBancaireMapper;
    OperationsReposetory operationsReposetory;
    @Override
    public ClientDto ajoutClient(ClientDto clientDto) {
        log.info("Ajout d'un Client");
        Client cl = compteBancaireMapper.deClientDto(clientDto);
        clientReposetory.save(cl);
        return clientDto;
    }

    @Override
    public CompteCourant ajouterCompteBancaireCourant(double soldeInitial, double decouvert, Long idClient) throws ClientNontrouverExeption {
        CompteCourant compteCourant = new CompteCourant();
        Client client = clientReposetory.findById(idClient).orElse(null);
        compteCourant.setId(UUID.randomUUID().toString());
        compteCourant.setDateCreation(new Date());
        compteCourant.setSolde(soldeInitial);
        compteCourant.setDecouvert(decouvert);
        if (client != null) {
            compteCourant.setClient(client);
        }else {
            throw new ClientNontrouverExeption("Client non trouver");
        }
        bnakReposetory.save(compteCourant);
        return compteCourant;
    }

    @Override
    public CompteSaving ajouterCompteBancaireSaving(double soldeInitial, double tauxDinteret, Long idClient) throws ClientNontrouverExeption {
        CompteSaving compteSaving = new CompteSaving();
        Client client = clientReposetory.findById(idClient).orElse(null);
        compteSaving.setId(UUID.randomUUID().toString());
        compteSaving.setDateCreation(new Date());
        compteSaving.setSolde(soldeInitial);
        compteSaving.setTauxDinteret(tauxDinteret);
        if (client != null) {
            compteSaving.setClient(client);
        }else {
            throw new ClientNontrouverExeption("Client non trouver");
        }
        bnakReposetory.save(compteSaving);
        return compteSaving;
    }

    @Override
    public List<ClientDto> listeClient() {
        List<Client> all = clientReposetory.findAll();
        List<ClientDto> collect = all.stream().map(cl -> compteBancaireMapper.deClient(cl)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public CompteBancaire getCompte(String idCompte) throws CompteBancaireNotFoundException {
        CompteBancaire byId = bnakReposetory.findById(idCompte).orElseThrow(()->new CompteBancaireNotFoundException("compte bancaire non trouver"));
        return byId;
    }

    @Override
    public void versement(String idCompte, double montant, String description) throws CompteBancaireNotFoundException {
        CompteBancaire compte = getCompte(idCompte);
        Operations operations = new Operations();
        operations.setDateOperation(new Date());
        operations.setType(TypeOperation.CRIDIT);
        operations.setMontant(montant);
        operations.setCompteBancaire(compte);
        operationsReposetory.save(operations);
        compte.setSolde(compte.getSolde()+montant);
        bnakReposetory.save(compte);
    }

    @Override
    public void retrait(String idCompte, double montant, String description) throws CompteBancaireNotFoundException, SoldeNonSuffisantException {
        CompteBancaire compte = getCompte(idCompte);
        if(compte.getSolde()<montant)
            throw  new SoldeNonSuffisantException("solde non suffisant");
        Operations operations = new Operations();
        operations.setDateOperation(new Date());
        operations.setType(TypeOperation.DEBIT);
        operations.setMontant(montant);
        operations.setCompteBancaire(compte);
        operationsReposetory.save(operations);
        compte.setSolde(compte.getSolde()-montant);
        bnakReposetory.save(compte);
    }

    @Override
    public void virement(String idCompteSource, String idCompteDestination, double montant) throws SoldeNonSuffisantException, CompteBancaireNotFoundException {
        retrait(idCompteSource,montant,"Transfert vers "+idCompteDestination);
        versement(idCompteDestination,montant,"Transfert de "+idCompteSource);
    }
    @Override
    public List<CompteBancaire> getComptes(){
        return bnakReposetory.findAll();
    }

    @Override
    public ClientDto getClient(Long id) throws ClientNontrouverExeption {
        Client client = clientReposetory.findById(id).orElseThrow(
                () -> new ClientNontrouverExeption("client non trouver")
        );
        return compteBancaireMapper.deClient(client);
    }

    @Override
    public ClientDto misAJourClient(ClientDto clientDto) {
        log.info("Ajout d'un Client");
        Client cl = compteBancaireMapper.deClientDto(clientDto);
        clientReposetory.save(cl);
        return clientDto;
    }
    @Override
    public void supprimerClient(Long id){
        clientReposetory.deleteById(id);
    }
}
