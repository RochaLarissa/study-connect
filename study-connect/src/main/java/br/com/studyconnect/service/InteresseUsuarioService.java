package br.com.studyconnect.service;

import br.com.studyconnect.dto.InteresseUsuarioRequest;
import br.com.studyconnect.dto.InteresseUsuarioResponse;
import br.com.studyconnect.model.InteresseUsuario;

import java.util.List;

public interface InteresseUsuarioService {

    InteresseUsuarioResponse save(InteresseUsuarioRequest interesseUsuarioRequest);

    List<InteresseUsuario> findAllByInteresseId(Long id);

    List<InteresseUsuario> findAllByUsuarioId(Long id);

    void deleteById(Long id);
}
