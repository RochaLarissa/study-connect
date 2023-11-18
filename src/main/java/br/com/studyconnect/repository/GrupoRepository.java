package br.com.studyconnect.repository;

import br.com.studyconnect.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{

    Grupo findByInteresseId(Long interesseId);

}
