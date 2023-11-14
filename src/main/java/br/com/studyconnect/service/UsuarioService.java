package br.com.studyconnect.service;

import br.com.studyconnect.dto.UsuarioRequest;
import br.com.studyconnect.dto.UsuarioResponse;
import br.com.studyconnect.model.Usuario;

public interface UsuarioService {

    Usuario save(UsuarioRequest sindicoRequest);

    Usuario update(Long id, UsuarioRequest sindicoRequest);

    UsuarioResponse findCompleteById(Long id);

    void deleteById(Long id);
}
