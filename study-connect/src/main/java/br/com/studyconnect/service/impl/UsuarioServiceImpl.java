package br.com.studyconnect.service.impl;

import br.com.studyconnect.dto.UsuarioRequest;
import br.com.studyconnect.dto.UsuarioResponse;
import br.com.studyconnect.model.Usuario;
import br.com.studyconnect.repository.UsuarioRepository;
import br.com.studyconnect.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService,
        UserDetailsService {

    private final UsuarioRepository usuarioRepository;


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

//        var interesseUsuario = interesseUsuarioService.findAllByUsuarioId(id);
//        usuario.setInteressesUsuario(interesseUsuario);
//
//        var usuarioGrupo = usuarioGrupoService.findAllByUsuarioId(id);
//        usuario.setUsuarioGrupos(usuarioGrupo);

        UsuarioResponse response = UsuarioResponse.build(usuario);
        return response;
    }

    @Override
    public Usuario buscarUsuarioPorId(Long idUsuario) {
        Optional<Usuario> optional = usuarioRepository.findById(idUsuario);
        if(optional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }
        return optional.get();
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        Optional<Usuario> optional = usuarioRepository.findByEmail(email);

        if(optional.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return optional.get();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return buscarUsuarioPorEmail(username);
    }

}
