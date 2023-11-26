package br.com.studyconnect.dto;

import br.com.studyconnect.model.Grupo;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Builder
@Data
public class GrupoDetalheResponse {

    private Long id;

    private String descricao;

    private InteresseResponse interesse;

    private List<UsuarioResponse> usuarios;

    public static GrupoDetalheResponse build(Grupo grupo) {
        return GrupoDetalheResponse.builder()
                .id(grupo.getId())
                .descricao(grupo.getDescricao())
                .build();
    }

    public static List<GrupoDetalheResponse> build(List<Grupo> grupos) {
        return !CollectionUtils.isEmpty(grupos)
                ? grupos.stream().map(GrupoDetalheResponse::build).toList()
                : Collections.emptyList();
    }
}
