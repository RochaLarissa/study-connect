package br.com.studyconnect.dto;

import br.com.studyconnect.model.Grupo;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Builder
@Data
public class GrupoResponse {

    private Long id;

    private String descricao;

    public static GrupoResponse build(Grupo grupo) {
        return GrupoResponse.builder()
                .id(grupo.getId())
                .descricao(grupo.getDescricao())
                .build();
    }

    public static List<GrupoResponse> build(List<Grupo> grupos) {
        return !CollectionUtils.isEmpty(grupos)
                ? grupos.stream().map(GrupoResponse::build).toList()
                : Collections.emptyList();
    }
}
