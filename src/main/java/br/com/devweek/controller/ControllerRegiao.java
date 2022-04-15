package br.com.devweek.controller;

import br.com.devweek.entities.Regiao;
import br.com.devweek.repository.RegiaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerRegiao {

    private final RegiaoRepository repository;

    public ControllerRegiao(RegiaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/regioes")
    public ResponseEntity<?> findAllRegioes() {
        try {
            List<Regiao> allRegioes = repository.findAll();
            System.out.println("Achou");
            if (allRegioes.isEmpty())
                System.out.println("Vazia");
            return new ResponseEntity<>(allRegioes, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("regioes/{id}")
    public ResponseEntity<Regiao> findRegioesById(@PathVariable Long id) {
        Optional<Regiao> regiaoOptional = repository.findById(id);
        if (regiaoOptional.isPresent()) {
            Regiao regiaoUID = regiaoOptional.get();
            return new ResponseEntity<>(regiaoUID, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
