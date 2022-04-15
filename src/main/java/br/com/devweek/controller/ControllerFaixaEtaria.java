package br.com.devweek.controller;

import br.com.devweek.entities.FaixaEtaria;
import br.com.devweek.repository.FaixaEtariaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerFaixaEtaria {

    private final FaixaEtariaRepository repository;

    public ControllerFaixaEtaria(FaixaEtariaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria() {
        try {
            List<FaixaEtaria> list = repository.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<FaixaEtaria> findByIdFaixaEtaria(@PathVariable Long id) {
        try {
            Optional<FaixaEtaria> optionalFaixaEtaria = repository.findById(id);
            if (optionalFaixaEtaria.isPresent()) {
                FaixaEtaria faixaEtariaUID = optionalFaixaEtaria.get();
                return new ResponseEntity<>(faixaEtariaUID, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa) {
        return repository.save(newFaixa);
    }

    @DeleteMapping("/faixaetaria/remover/{id}")
    public void deleteFaixaEtaria(@PathVariable Long id) {
        repository.deleteById(id);

    }
}
