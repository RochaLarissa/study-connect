package br.com.studyconnect.repository;

import br.com.studyconnect.model.InteresseUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteresseUsuarioRepository extends JpaRepository<InteresseUsuario, Long>{

    List<InteresseUsuario> findAllByInteresseId(Long id);

    List<InteresseUsuario> findAllByUsuarioId(Long id);

}
