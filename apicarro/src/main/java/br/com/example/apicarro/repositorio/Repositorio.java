package br.com.example.apicarro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.example.apicarro.modelo.Carro;

public interface Repositorio extends JpaRepository<Carro, Integer>{

}
