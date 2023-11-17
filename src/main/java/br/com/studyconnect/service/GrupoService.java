package br.com.studyconnect.service;

import br.com.studyconnect.dto.GrupoRequest;
import br.com.studyconnect.dto.GrupoResponse;
import br.com.studyconnect.dto.UsuarioRequest;
import br.com.studyconnect.model.Interesse;

public interface GrupoService {

    GrupoResponse save(GrupoRequest grupoRequest);

    GrupoResponse update(Long id, GrupoRequest grupoRequest);

    GrupoResponse findCompleteById(Long id);

    void verificaGrupos(Interesse interesse);

    void deleteById(Long id);
}
