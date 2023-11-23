package br.com.studyconnect.dto;

import lombok.Data;

@Data
public class InteresseRequest {

    private Long id;

    private String disciplina;

    private String turno;

    private String tipo;
}
