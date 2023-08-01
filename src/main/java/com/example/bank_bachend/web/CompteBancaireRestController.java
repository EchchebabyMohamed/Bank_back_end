package com.example.bank_bachend.web;


import com.example.bank_bachend.DTOS.CompteBancaireDto;
import com.example.bank_bachend.DTOS.CompteHestoriesDto;
import com.example.bank_bachend.DTOS.OperationsDto;
import com.example.bank_bachend.Exeptions.CompteBancaireNotFoundException;
import com.example.bank_bachend.Service.CompteBancaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CompteBancaireRestController {
    CompteBancaireService compteBancaireService;
    @GetMapping("/comptes/{id}")
    public CompteBancaireDto getCompte(@PathVariable String id) throws CompteBancaireNotFoundException {
        return compteBancaireService.getCompte(id);
    }
    @GetMapping("/comptes")
    public List<CompteBancaireDto> listComptes(){
        return compteBancaireService.getComptes();
    }
    @GetMapping("/comptes/{id}/operations")
    public List<OperationsDto> operationDeCompte(@PathVariable String id){
       return compteBancaireService.getOperations(id);
    }
    @GetMapping("/comptes/{id}/pageoperations")
    public CompteHestoriesDto operationHestoryDeCompte(@PathVariable String id, @RequestParam(name = "page",defaultValue = "0") int page, @RequestParam(name = "size",defaultValue = "5") int size) throws CompteBancaireNotFoundException {
        return compteBancaireService.getCompteHestory(id,page,size);
    }
}
