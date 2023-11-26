package br.com.studyconnect.model;


import br.com.studyconnect.dto.InteresseUsuarioRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "interesse_usuario")
public class InteresseUsuario {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JoinColumn(name = "id_interesse", referencedColumnName = "id", updatable = false,
            foreignKey = @ForeignKey(name = "INTERESSE_USUARIO_FK_INTERESSE"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Interesse interesse;

    @JsonIgnore
    @NotNull
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", updatable = false,
            foreignKey = @ForeignKey(name = "INTERESSE_USUARIO_FK_USUARIO"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public static InteresseUsuario build(InteresseUsuarioRequest request) {
        return InteresseUsuario.builder()
                .id(request.getId())
                .interesse(Interesse.build(request.getInteresseId()))
                .usuario(Usuario.build(request.getUsuarioId()))
                .build();
    }
}
