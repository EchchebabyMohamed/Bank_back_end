package com.example.bank_bachend.reposetory;

import com.example.bank_bachend.enteties.Operations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationsReposetory extends JpaRepository<Operations,Long> {
}
