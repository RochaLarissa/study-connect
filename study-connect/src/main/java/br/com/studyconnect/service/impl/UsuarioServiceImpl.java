package br.com.studyconnect.service.impl;

import br.com.studyconnect.dto.*;
import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.Interesse;
import br.com.studyconnect.model.Usuario;
import br.com.studyconnect.repository.UsuarioRepository;
import br.com.studyconnect.service.InteresseUsuarioService;
import br.com.studyconnect.service.UsuarioGrupoService;
import br.com.studyconnect.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService,
        UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    private final InteresseUsuarioService interesseUsuarioService;

    private final UsuarioGrupoService usuarioGrupoService;

    private final PasswordEncoder passwordEncoder;


    @Override
    public UsuarioResponse save(UsuarioRequest usuarioRequest) {
        var usuario = Usuario.build(usuarioRequest);
        usuario.setPrivilegio("USER");
        usuario.setSenha(passwordEncoder.encode(usuarioRequest.getSenha()));

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
    public UsuarioDetalheResponse findCompleteById(Long id) {
        var usuario = usuarioRepository.findCompleteById(id).orElseThrow(EntityNotFoundException::new);

        var interesseUsuario = interesseUsuarioService.findAllByUsuarioId(id);
        List<InteresseResponse> interesses = new ArrayList<>();
        interesseUsuario.forEach(iu -> {
            var interesse = InteresseResponse.build(iu.getInteresse());
            interesses.add(interesse);
        });

        var usuarioGrupo = usuarioGrupoService.findAllByUsuarioId(id);
        List<GrupoResponse> grupos = new ArrayList<>();
        usuarioGrupo.forEach(ug -> {
            var grupo = GrupoResponse.build(ug.getGrupo());
            grupos.add(grupo);
        });

        UsuarioDetalheResponse response = UsuarioDetalheResponse.build(usuario);
        response.setInteresses(interesses);
        response.setGrupos(grupos);

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
