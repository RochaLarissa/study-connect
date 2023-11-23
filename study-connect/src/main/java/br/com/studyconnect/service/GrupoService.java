package br.com.studyconnect.service;

import br.com.studyconnect.dto.GrupoRequest;
import br.com.studyconnect.dto.GrupoResponse;
import br.com.studyconnect.dto.UsuarioRequest;
import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.Interesse;
import br.com.studyconnect.model.Usuario;

public interface GrupoService {

    GrupoResponse update(Long grupoId, GrupoRequest grupoRequest);

    GrupoResponse findCompleteById(Long id);

    Grupo verificaGrupos(Interesse interesse, Usuario novoUsuario);

    GrupoResponse findAllGruposByUsuarioId(Long usuarioId);
}
