package br.com.studyconnect.model;


import br.com.studyconnect.dto.UsuarioRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Optional;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String senha;

    private String curso;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Interesse> interesses;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<UsuarioGrupo> usuarioGrupos;

    public static Usuario build(UsuarioRequest request) {
        return Usuario.builder()
                .id(request.getId())
                .email(request.getEmail())
                .nome(request.getNome())
                .senha(request.getSenha())
                .curso(request.getCurso())
                .interesses(request.getInteresses())
                .build();
    }

}
