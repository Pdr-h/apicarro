package br.com.example.apicarro.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.List;

import br.com.example.apicarro.modelo.Carro;
import br.com.example.apicarro.service.CarroService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/carros")
public class Controle {
    private final CarroService carroService;
    
    public Controle(CarroService carroService){
        this.carroService = carroService;
    }

    @GetMapping
    public List<Carro> listarTodos(){
        return carroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscaId(@PathVariable Integer id){
        Optional<Carro> carro = carroService.buscaId(id);
        return carro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carro salvar(@RequestBody Carro carro){
        return carroService.salvar(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable Integer id, @RequestBody Carro novoCarro){
        return carroService.buscaId(id)
            .map(carro ->{
                carro.setPlaca(novoCarro.getPlaca());
                carro.setMarca(novoCarro.getMarca());
                carro.setModelo(novoCarro.getModelo());
                carro.setAno(novoCarro.getAno());            
                return ResponseEntity.ok(carroService.salvar(carro));
            }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Integer id){
        if (carroService.buscaId(id).isPresent()) {
            carroService.apagar(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
