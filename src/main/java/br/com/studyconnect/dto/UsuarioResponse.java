package br.com.studyconnect.dto;

import br.com.studyconnect.model.Usuario;
import br.com.studyconnect.model.UsuarioGrupo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UsuarioResponse {

    private Long id;

    private String email;

    private String nome;

    private String curso;

    private List<UsuarioGrupo> usuarioGrupos;
    public static UsuarioResponse build(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .curso(usuario.getCurso())
                .usuarioGrupos(usuario.getUsuarioGrupos())
                .build();
    }
}
