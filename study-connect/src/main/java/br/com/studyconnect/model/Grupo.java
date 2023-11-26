package br.com.studyconnect.model;


import br.com.studyconnect.dto.GrupoRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descricao;

    @JsonIgnore
    @JoinColumn(name = "id_interesse", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Interesse interesse;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY)
    private List<UsuarioGrupo> usuarioGrupos;

    public static Grupo build(Long id) {
        return Grupo.builder()
                .id(id)
                .build();
    }

    public static Grupo build(GrupoRequest request) {
        return Grupo.builder()
                .id(request.getId())
                .descricao(request.getDescricao())
                .interesse(Interesse.build(request.getInteresse()))
                .usuarioGrupos(request.getUsuarioGrupos())
                .build();
    }
}
