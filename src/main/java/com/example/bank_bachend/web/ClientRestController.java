package com.example.bank_bachend.web;

import com.example.bank_bachend.DTOS.ClientDto;
import com.example.bank_bachend.Exeptions.ClientNontrouverExeption;
import com.example.bank_bachend.Service.CompteBancaireService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ClientRestController {
    private CompteBancaireService compteBancaireService;
   @GetMapping("/clients")
    public List<ClientDto> clientList(){
        return compteBancaireService.listeClient();
    }
    @GetMapping("/clients/{id}")
    public ClientDto getClient(@PathVariable(name = "id") Long id) throws ClientNontrouverExeption {
        ClientDto client = compteBancaireService.getClient(id);
        return client;
    }
    @PostMapping("/clients")
    public ClientDto ajouterClient(@RequestBody ClientDto clientDto){
       return compteBancaireService.ajoutClient(clientDto);
   }
   @PutMapping("/clients/{id}")
    public ClientDto misAJourClient(@PathVariable Long id,@RequestBody ClientDto clientDto){
       clientDto.setId(id);
       return compteBancaireService.misAJourClient(clientDto);
   }
   @DeleteMapping("/clients/{id}")
    public void supprimerClient(@PathVariable Long id){
       compteBancaireService.supprimerClient(id);
   }
}
