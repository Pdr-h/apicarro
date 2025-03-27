package br.com.example.apicarro.service;

import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;

import br.com.example.apicarro.repositorio.Repositorio;
import br.com.example.apicarro.modelo.Carro;

@Service
public class CarroService {
    private final Repositorio repositorio;

    public CarroService(Repositorio repositorio){
        this.repositorio = repositorio;
    }

    public Optional<Carro> buscaId(Integer id){
        return repositorio.findById(id);
    }

    public List<Carro> listarTodos(){
        return repositorio.findAll();
    }

    public Carro salvar(Carro carro){
        return repositorio.save(carro);
    }

    public void apagar(Integer id){
        repositorio.deleteById(id);
    }
}
