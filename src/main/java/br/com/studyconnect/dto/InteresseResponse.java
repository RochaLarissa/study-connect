package br.com.studyconnect.dto;

import br.com.studyconnect.model.Interesse;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InteresseResponse {

    private Long id;

    private String disciplina;

    private String turno;
    public static InteresseResponse build(Interesse interesse) {
        return InteresseResponse.builder()
                .id(interesse.getId())
                .disciplina(interesse.getDisciplina())
                .turno(interesse.getTurno())
                .build();
    }
}
