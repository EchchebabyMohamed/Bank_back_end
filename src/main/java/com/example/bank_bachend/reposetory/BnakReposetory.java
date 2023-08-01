package com.example.bank_bachend.reposetory;

import com.example.bank_bachend.enteties.CompteBancaire;
import com.example.bank_bachend.enteties.Operations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BnakReposetory extends JpaRepository<CompteBancaire,String> {

}
