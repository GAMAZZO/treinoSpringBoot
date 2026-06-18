package com.SpringBoot.AprenderSpring.requests;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AnimePostRequestBody { // Não precisa do id, quem faz é o Mysql automaticamente
    @NotBlank(message = "The anime name cannot be blank")
     private String name;
}
