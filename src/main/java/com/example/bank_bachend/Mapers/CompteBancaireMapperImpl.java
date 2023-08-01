package com.example.bank_bachend.Mapers;

import com.example.bank_bachend.DTOS.ClientDto;
import com.example.bank_bachend.DTOS.CompteBancaireCourantDto;
import com.example.bank_bachend.DTOS.CompteBancaireSavingDto;
import com.example.bank_bachend.DTOS.OperationsDto;
import com.example.bank_bachend.enteties.Client;
import com.example.bank_bachend.enteties.CompteCourant;
import com.example.bank_bachend.enteties.CompteSaving;
import com.example.bank_bachend.enteties.Operations;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CompteBancaireMapperImpl {
    public ClientDto deClient(Client client){
        ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(client,clientDto);
        return clientDto;
    }
    public Client deClientDto(ClientDto clientDto){
        Client client = new Client();
        BeanUtils.copyProperties(clientDto,client);
        return client;
    }
    public CompteBancaireCourantDto deCompteBancaireCourant(CompteCourant compteCourant){
        CompteBancaireCourantDto compteBancaireCourantDto = new CompteBancaireCourantDto();
        BeanUtils.copyProperties(compteCourant,compteBancaireCourantDto);
        compteBancaireCourantDto.setClientDto(deClient(compteCourant.getClient()));
        compteBancaireCourantDto.setType(compteCourant.getClass().getSimpleName());
        return compteBancaireCourantDto;
    }

    public CompteCourant deCompteBancaireCourantDto(CompteBancaireCourantDto compteBancaireCourantDto){
        CompteCourant compteCourant = new CompteCourant();
        BeanUtils.copyProperties(compteBancaireCourantDto,compteCourant);
        compteCourant.setClient(deClientDto(compteBancaireCourantDto.getClientDto()));
        return compteCourant;
    }

    public CompteBancaireSavingDto deCompteBancaireSaving(CompteSaving compteSaving){
        CompteBancaireSavingDto compteBancaireSavingDto = new CompteBancaireSavingDto();
        BeanUtils.copyProperties(compteSaving,compteBancaireSavingDto);
        compteBancaireSavingDto.setClientDto(deClient(compteSaving.getClient()));
        compteBancaireSavingDto.setType(compteSaving.getClass().getSimpleName());
        return compteBancaireSavingDto;
    }

    public CompteSaving deCompteBancaireSavingDto(CompteBancaireSavingDto compteBancaireSavingDto){
        CompteSaving compteSaving = new CompteSaving();
        BeanUtils.copyProperties(compteBancaireSavingDto,compteSaving);
        compteSaving.setClient(deClientDto(compteBancaireSavingDto.getClientDto()));
        return compteSaving;
    }
    public OperationsDto deOperations(Operations operations){
        OperationsDto operationsDto = new OperationsDto();
        BeanUtils.copyProperties(operations,operationsDto);
        return operationsDto;
    }
    public Operations deOperationsDto(OperationsDto operationsDto){
        Operations operations = new  Operations();
        BeanUtils.copyProperties(operationsDto,operations);
        return operations;
    }
}
