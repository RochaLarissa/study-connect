package br.com.studyconnect.service.impl;

import br.com.studyconnect.dto.UsuarioRequest;
import br.com.studyconnect.dto.UsuarioResponse;
import br.com.studyconnect.model.Usuario;
import br.com.studyconnect.repository.UsuarioRepository;
import br.com.studyconnect.service.InteresseUsuarioService;
import br.com.studyconnect.service.UsuarioGrupoService;
import br.com.studyconnect.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioGrupoService usuarioGrupoService;

    private final InteresseUsuarioService interesseUsuarioService;

    @Override
    public UsuarioResponse save(UsuarioRequest usuarioRequest) {
        var usuario = Usuario.build(usuarioRequest);

        var response = usuarioRepository.save(usuario);

        return UsuarioResponse.build(response);
    }

    @Override
    public UsuarioResponse update(Long id, UsuarioRequest usuarioRequest) {
        var usuario = Usuario.build(usuarioRequest);
        usuario.setId(id);

        var response = usuarioRepository.save(usuario);

        return UsuarioResponse.build(response);
    }

    @Override
    public UsuarioResponse findCompleteById(Long id) {
        var usuario = usuarioRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        var interesseUsuario = interesseUsuarioService.findAllByInteresseId(id);
        usuario.setInteressesUsuario(interesseUsuario);

        var usuarioGrupo = usuarioGrupoService.findAllByUsuarioId(id);
        usuario.setUsuarioGrupos(usuarioGrupo);

        UsuarioResponse response = UsuarioResponse.build(usuario);
        return response;
    }

    @Override
    public void deleteById(Long id) {
        existsById(id);
        usuarioRepository.deleteById(id);
    }

    private void existsById(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
    }
}
