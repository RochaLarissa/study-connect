package br.com.studyconnect.service;

import br.com.studyconnect.dto.UsuarioDetalheResponse;
import br.com.studyconnect.dto.UsuarioRequest;
import br.com.studyconnect.dto.UsuarioResponse;
import br.com.studyconnect.model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService {

    UsuarioResponse save(UsuarioRequest usuarioRequest);

    UsuarioResponse update(Long id, UsuarioRequest usuarioRequest);

    UsuarioDetalheResponse findCompleteById(Long id);

    Usuario buscarUsuarioPorId(Long idUsuario);

    Usuario buscarUsuarioPorEmail(String email);
}
