package br.com.studyconnect.service;

import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.Usuario;
import br.com.studyconnect.model.UsuarioGrupo;

import java.util.List;

public interface UsuarioGrupoService {

    void save(Usuario usuario, Grupo grupo);

    void update(Long usuarioId, Long grupoId);

    List<UsuarioGrupo> findAllByUsuarioId(Long usuarioId);

    List<UsuarioGrupo> findAllByGrupoId(Long grupoId);

    Boolean existsByUsuarioAndGrupo(Long usuarioId, Long grupoId);

}
