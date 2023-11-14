package br.com.studyconnect.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(nullable = false)
    private String disciplina;

    @Column(nullable = false)
    private String turno;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY)
    private List<UsuarioGrupo> usuarioGrupos;

}
