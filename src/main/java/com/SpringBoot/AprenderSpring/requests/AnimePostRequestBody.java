package com.SpringBoot.AprenderSpring.requests;

import lombok.Data;

@Data
public class AnimePostRequestBody { // Não precisa do id, quem faz é o Mysql automaticamente
     private String name;
}
