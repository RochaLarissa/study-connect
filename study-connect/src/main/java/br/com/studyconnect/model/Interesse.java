package br.com.studyconnect.model;


import br.com.studyconnect.dto.InteresseRequest;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "interesse")
public class Interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String disciplina;

    @Column(nullable = false)
    private String turno;

    @Column(nullable = false)
    private String tipo;

    public static Interesse build(Long id) {
        return Interesse.builder()
                .id(id)
                .build();
    }

    public static Interesse build(InteresseRequest request) {
        return Interesse.builder()
                .id(request.getId())
                .disciplina(request.getDisciplina())
                .turno(request.getTurno())
                .tipo(request.getTipo())
                .build();
    }

}
