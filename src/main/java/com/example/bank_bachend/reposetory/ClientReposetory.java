package com.example.bank_bachend.reposetory;

import com.example.bank_bachend.enteties.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientReposetory extends JpaRepository<Client,Long> {
}
