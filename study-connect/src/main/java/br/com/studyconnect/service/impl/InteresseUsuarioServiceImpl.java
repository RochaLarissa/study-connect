package br.com.studyconnect.service.impl;

import br.com.studyconnect.dto.InteresseUsuarioRequest;
import br.com.studyconnect.dto.InteresseUsuarioResponse;
import br.com.studyconnect.events.InteresseUsuarioSavedEvent;
import br.com.studyconnect.model.InteresseUsuario;
import br.com.studyconnect.repository.InteresseUsuarioRepository;
import br.com.studyconnect.service.InteresseUsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InteresseUsuarioServiceImpl implements InteresseUsuarioService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private final InteresseUsuarioRepository interesseUsuarioRepository;

    @Override
    public InteresseUsuarioResponse save(InteresseUsuarioRequest interesseUsuarioRequest) {
        var interesseUsuario = InteresseUsuario.build(interesseUsuarioRequest);
        var savedInteresseUsuario = interesseUsuarioRepository.save(interesseUsuario);

        eventPublisher.publishEvent(new InteresseUsuarioSavedEvent(savedInteresseUsuario));

        return InteresseUsuarioResponse.build(savedInteresseUsuario);
    }

    @Override
    public List<InteresseUsuario> findAllByInteresseId(Long id) {
        return interesseUsuarioRepository.findAllByInteresseId(id);
    }

    @Override
    public List<InteresseUsuario> findAllByUsuarioId(Long id) {
        return interesseUsuarioRepository.findAllByUsuarioId(id);
    }

    @Override
    public void deleteById(Long id) {
        existsById(id);
        interesseUsuarioRepository.deleteById(id);
    }

    private void existsById(Long id) {
        if (!interesseUsuarioRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
    }
}
