package br.com.studyconnect.dto;

import lombok.Data;

@Data
public class InteresseUsuarioRequest {

    private Long id;

    private Long interesseId;

    private Long usuarioId;
}
