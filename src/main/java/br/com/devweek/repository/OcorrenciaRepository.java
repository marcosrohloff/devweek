package br.com.devweek.repository;

import br.com.devweek.entities.IncidenciaExame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<IncidenciaExame, Long> {
}
