package br.com.studyconnect.service.impl;

import br.com.studyconnect.dto.UsuarioRequest;
import br.com.studyconnect.dto.UsuarioResponse;
import br.com.studyconnect.model.Usuario;
import br.com.studyconnect.repository.UsuarioGrupoRepository;
import br.com.studyconnect.repository.UsuarioRepository;
import br.com.studyconnect.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioGrupoRepository usuarioGrupoRepository;

    /*SEMPRE QUE EU FIZER UM SAVE OU UPDATE EM INTERESSE, EU VERIFICO SE EXISTE OUTRO USUARIO
    * COM O MESMO INTERESSE [DISCIPLINA E TURNO]
    * CASO HAJA, EU CRIO UM GRUPO OU ADD O USUARIO A UM GRUPO EXISTENTE */
    @Override
    public Usuario save(UsuarioRequest usuarioRequest) {
        var usuario = Usuario.build(usuarioRequest);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Long id, UsuarioRequest usuarioRequest) {
        var usuario = Usuario.build(usuarioRequest);
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioResponse findCompleteById(Long id) {
        var usuario = usuarioRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        var usuarioGrupo = usuarioGrupoRepository.findAllByUsuarioId(id);
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
