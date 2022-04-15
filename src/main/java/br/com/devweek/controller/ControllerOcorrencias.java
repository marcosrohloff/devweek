package br.com.devweek.controller;

import br.com.devweek.entities.IncidenciaExame;
import br.com.devweek.repository.OcorrenciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerOcorrencias {

    private final OcorrenciaRepository repository;

    public ControllerOcorrencias(OcorrenciaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ocorrencias")
    public ResponseEntity<List<IncidenciaExame>> findOcorrencias() {
        List<IncidenciaExame> list = repository.findAll();
        if (list.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/ocorrencias/{id}")
    public ResponseEntity<IncidenciaExame> findOcorrenciasById(@PathVariable Long id) {
        Optional<IncidenciaExame> ocorrenciaOptional = repository.findById(id);
        if (ocorrenciaOptional.isPresent()) {
            IncidenciaExame incidenciaExame = ocorrenciaOptional.get();
            return new ResponseEntity<>(incidenciaExame, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
