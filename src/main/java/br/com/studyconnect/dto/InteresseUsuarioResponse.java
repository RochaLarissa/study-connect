package br.com.studyconnect.dto;

import br.com.studyconnect.model.Interesse;
import br.com.studyconnect.model.InteresseUsuario;
import lombok.Builder;
import lombok.Data;

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
}
