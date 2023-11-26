package br.com.studyconnect.service;

import br.com.studyconnect.dto.InteresseRequest;
import br.com.studyconnect.dto.InteresseResponse;
import br.com.studyconnect.dto.UsuarioRequest;
import br.com.studyconnect.dto.UsuarioResponse;
import br.com.studyconnect.model.Interesse;
import br.com.studyconnect.model.Usuario;

import java.util.List;

public interface InteresseService {

    InteresseResponse save(InteresseRequest interesseRequest);

    InteresseResponse update(Long id, InteresseRequest interesseRequest);

    InteresseResponse findCompleteById(Long id);

    List<InteresseResponse> findAll();

    void deleteById(Long id);
}
