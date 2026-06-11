package com.SpringBoot.AprenderSpring.domain;
// Representa o que tem no banco de dados

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //vai gerar os Get Set Equal Hashcode
@AllArgsConstructor //gerar um contrutor com todos os valores
@NoArgsConstructor // JPA precisa de um construtor vazio para criar a entidade
@Entity
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
