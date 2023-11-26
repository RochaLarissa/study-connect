package br.com.studyconnect.dto;

import br.com.studyconnect.model.Interesse;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Builder
@Data
public class InteresseResponse {

    private Long id;

    private String disciplina;

    private String turno;

    private String tipo;

    public static InteresseResponse build(Long id) {
        return InteresseResponse.builder()
                .id(id)
                .build();
    }

    public static InteresseResponse build(Interesse interesse) {
        return InteresseResponse.builder()
                .id(interesse.getId())
                .disciplina(interesse.getDisciplina())
                .turno(interesse.getTurno())
                .tipo(interesse.getTipo())
                .build();
    }

    public static List<InteresseResponse> build(List<Interesse> interesses) {
        return !CollectionUtils.isEmpty(interesses)
                ? interesses.stream().map(InteresseResponse::build).toList()
                : Collections.emptyList();
    }
}
