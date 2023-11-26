package br.com.studyconnect.repository;

import br.com.studyconnect.model.UsuarioGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioGrupoRepository extends JpaRepository<UsuarioGrupo, Long>{

    List<UsuarioGrupo> findAllByUsuarioId(Long id);

    List<UsuarioGrupo> findAllByGrupoId(Long id);

    Boolean existsByUsuarioIdAndGrupoId(Long usuarioId, Long grupoId);

}
