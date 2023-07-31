package com.example.bank_bachend.reposetory;

import com.example.bank_bachend.enteties.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BnakReposetory extends JpaRepository<CompteBancaire,String> {
}
