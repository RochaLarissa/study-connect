package br.com.studyconnect.dto;

import br.com.studyconnect.model.Interesse;
import br.com.studyconnect.model.InteresseUsuario;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Builder
@Data
public class InteresseUsuarioResponse {

    private Long id;

    private InteresseResponse interesse;

    private UsuarioResponse usuario;
    public static InteresseUsuarioResponse build(InteresseUsuario interesseUsuario) {
        return InteresseUsuarioResponse.builder()
                .id(interesseUsuario.getId())
                .interesse(InteresseResponse.build(interesseUsuario.getInteresse()))
                .usuario(UsuarioResponse.build(interesseUsuario.getUsuario()))
                .build();
    }

    public static List<InteresseUsuarioResponse> build(List<InteresseUsuario> interesseUsuarios) {
        return !CollectionUtils.isEmpty(interesseUsuarios)
                ? interesseUsuarios.stream().map(InteresseUsuarioResponse::build).toList()
                : Collections.emptyList();
    }
}
