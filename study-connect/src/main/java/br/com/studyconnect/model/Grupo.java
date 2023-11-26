package br.com.studyconnect.model;


import br.com.studyconnect.dto.GrupoRequest;
import br.com.studyconnect.dto.InteresseResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.Collections;
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
    @JoinColumn(name = "id_interesse", referencedColumnName = "id", updatable = false)
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
                .build();
    }
}
