package com.example.bank_bachend.reposetory;

import com.example.bank_bachend.enteties.Operations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationsReposetory extends JpaRepository<Operations,Long> {
    public List<Operations> findByCompteBancaire_Id(String id);
    public Page<Operations> findByCompteBancaire_Id(String id, Pageable pageable);
}
