package com.SpringBoot.AprenderSpring.domain;
// Representa o que tem no banco de dados

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //vai gerar os Get, Set, Equal, Hashcode
@AllArgsConstructor  //Gera um contrutor com todos os valores
@NoArgsConstructor   // JPA precisa de um construtor vazio para criar a entidade
@Entity     // Diz que esta classe representa uma tabela do banco
@Builder    // Builder serve para construir objetos de forma mais organizada
public class Anime {
    @Id     //(Hibernate sabe que essa é a chave primária)
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // QUem cria o Id é o Mysql
    private Long id;
    private String name;

}
