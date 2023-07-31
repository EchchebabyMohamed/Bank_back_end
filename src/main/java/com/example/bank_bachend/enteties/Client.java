package com.example.bank_bachend.enteties;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String Emai;
    @Column(length = 10)
    private String tel;
    @OneToMany(mappedBy = "client")
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<CompteBancaire> compteBancaires;
}
