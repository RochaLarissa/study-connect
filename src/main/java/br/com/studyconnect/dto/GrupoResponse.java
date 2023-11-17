package br.com.studyconnect.dto;

import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.UsuarioGrupo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GrupoResponse {

    private Long id;

    private InteresseResponse interesse;

    private List<UsuarioGrupo> usuarioGrupos;

    public static GrupoResponse build(Grupo grupo) {
        return GrupoResponse.builder()
                .id(grupo.getId())
                .interesse(InteresseResponse.build(grupo.getInteresse()))
                .usuarioGrupos(grupo.getUsuarioGrupos())
                .build();
    }
}
