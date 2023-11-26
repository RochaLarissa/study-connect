package br.com.studyconnect.service.impl;

import br.com.studyconnect.dto.InteresseRequest;
import br.com.studyconnect.dto.InteresseResponse;
import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.Interesse;
import br.com.studyconnect.repository.InteresseRepository;
import br.com.studyconnect.service.InteresseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InteresseServiceImpl implements InteresseService {

    private final InteresseRepository interesseRepository;

    @Override
    public InteresseResponse save(InteresseRequest interesseRequest) {
        var interesse = Interesse.build(interesseRequest);
        var response = interesseRepository.save(interesse);

        return InteresseResponse.build(response);
    }

    @Override
    public InteresseResponse update(Long id, InteresseRequest interesseRequest) {
        var interesse = Interesse.build(interesseRequest);
        interesse.setId(id);

        var response = interesseRepository.save(interesse);

        return InteresseResponse.build(response);
    }

    @Override
    public InteresseResponse findCompleteById(Long id) {
        var interesse = interesseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return InteresseResponse.build(interesse);
    }

    @Override
    public List<InteresseResponse> findAll() {
        var interesses = interesseRepository.findAll();
        return InteresseResponse.build(interesses);
    }

    @Override
    public void deleteById(Long id) {
        existsById(id);
        interesseRepository.deleteById(id);
    }

    private void existsById(Long id) {
        if (!interesseRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
    }
}
