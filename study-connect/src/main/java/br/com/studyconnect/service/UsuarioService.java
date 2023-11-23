package br.com.studyconnect.service;

import br.com.studyconnect.dto.UsuarioRequest;
import br.com.studyconnect.dto.UsuarioResponse;

public interface UsuarioService {

    UsuarioResponse save(UsuarioRequest usuarioRequest);

    UsuarioResponse update(Long id, UsuarioRequest usuarioRequest);

    UsuarioResponse findCompleteById(Long id);

    void deleteById(Long id);
}