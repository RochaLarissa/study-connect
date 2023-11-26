package br.com.studyconnect.repository;

import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u "
            + "FROM Usuario u "
            + "  LEFT JOIN u.usuarioGrupos AS usuarioGrupos "
            + "  LEFT JOIN u.interessesUsuario AS interessesUsuario "
            + "WHERE u.id = ?1 ")
    Optional<Usuario> findCompleteById(Long id);

}
