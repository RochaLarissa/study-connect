package br.com.studyconnect.dto;

import br.com.studyconnect.model.Usuario;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UsuarioDetalheResponse {

    private Long id;

    private String email;

    private String nome;

    private String curso;

    private List<InteresseResponse> interesses;

    private List<GrupoResponse> grupos;

    public static UsuarioDetalheResponse build(Usuario usuario) {
        return UsuarioDetalheResponse.builder()
                .id(usuario.getId())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .curso(usuario.getCurso())
                .build();
    }
}
