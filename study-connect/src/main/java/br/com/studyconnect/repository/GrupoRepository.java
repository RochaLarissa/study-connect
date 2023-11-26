package br.com.studyconnect.repository;

import br.com.studyconnect.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{

    @Query("SELECT g "
            + "FROM Grupo g "
            + "  LEFT JOIN g.interesse AS interesse "
            + "WHERE g.id = ?1 ")
    Optional<Grupo> findCompleteById(Long id);

    Grupo findByInteresseId(Long interesseId);

    List<Grupo> findAllByUsuarioGruposUsuarioId(Long usuarioId);

}
