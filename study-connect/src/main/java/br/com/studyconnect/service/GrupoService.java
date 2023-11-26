package br.com.studyconnect.service;

import br.com.studyconnect.dto.GrupoDetalheResponse;
import br.com.studyconnect.dto.GrupoRequest;
import br.com.studyconnect.dto.GrupoResponse;
import br.com.studyconnect.dto.UsuarioRequest;
import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.Interesse;
import br.com.studyconnect.model.Usuario;

import java.util.List;

public interface GrupoService {

    GrupoResponse update(Long grupoId, GrupoRequest grupoRequest);

    GrupoDetalheResponse findCompleteById(Long id);

    Grupo verificaGrupos(Interesse interesse, Usuario novoUsuario);

    List<GrupoResponse> findAllGruposByUsuarioId(Long usuarioId);
}
