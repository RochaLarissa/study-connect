package br.com.studyconnect.dto;

import br.com.studyconnect.model.Interesse;
import br.com.studyconnect.model.UsuarioGrupo;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioRequest {

    private Long id;

    private String email;

    private String nome;

    private String senha;

    private String curso;

    private List<Interesse> interesses;
}
