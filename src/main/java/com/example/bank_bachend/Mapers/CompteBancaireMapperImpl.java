package com.example.bank_bachend.Mapers;

import com.example.bank_bachend.DTOS.ClientDto;
import com.example.bank_bachend.enteties.Client;
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
}
