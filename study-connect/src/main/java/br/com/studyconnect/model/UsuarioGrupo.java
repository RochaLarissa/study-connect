package br.com.studyconnect.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "usuario_grupo")
public class UsuarioGrupo {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @NotNull
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", updatable = false,
            foreignKey = @ForeignKey(name = "USUARIO_GRUPO_FK_USUARIO"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @NotNull
    @JoinColumn(name = "id_grupo", referencedColumnName = "id", updatable = false,
            foreignKey = @ForeignKey(name = "USUARIO_GRUPO_FK_GRUPO"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Grupo grupo;

}
