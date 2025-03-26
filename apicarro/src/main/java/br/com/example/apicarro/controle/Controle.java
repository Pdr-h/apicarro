package br.com.example.apicarro.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.apicarro.modelo.Carro;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controle {
    @GetMapping("")
    public String mensagem(){
        return "API Carro - Spring Boot";
    }

    @GetMapping("/nomeDoCarro/{carro}")
        public String nomeCar(@PathVariable String carro){
            return "Carro: " + carro;
        }
       
   @PostMapping("/carro")
   public Carro carro(@RequestBody Carro c) {
       return c;
   }
       
}
