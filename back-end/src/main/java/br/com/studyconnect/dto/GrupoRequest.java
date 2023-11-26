package br.com.studyconnect.dto;

import br.com.studyconnect.model.UsuarioGrupo;
import lombok.Data;

import java.util.List;

@Data
public class GrupoRequest {

    private Long id;

    private String descricao;

}
