package br.com.studyconnect.service.impl;

import br.com.studyconnect.dto.GrupoRequest;
import br.com.studyconnect.dto.GrupoResponse;
import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.Interesse;
import br.com.studyconnect.model.InteresseUsuario;
import br.com.studyconnect.repository.GrupoRepository;
import br.com.studyconnect.repository.InteresseUsuarioRepository;
import br.com.studyconnect.service.GrupoService;
import br.com.studyconnect.service.InteresseUsuarioService;
import br.com.studyconnect.service.UsuarioGrupoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository grupoRepository;
    private final InteresseUsuarioService interesseUsuarioService;
    private final UsuarioGrupoService usuarioGrupoService;

    @Override
    public GrupoResponse save(GrupoRequest grupoRequest) {
        var grupo = Grupo.build(grupoRequest);
        var response = grupoRepository.save(grupo);

        return GrupoResponse.build(response);
    }

    @Override
    public GrupoResponse update(Long id, GrupoRequest grupoRequest) {
        var grupo = Grupo.build(grupoRequest);
        grupo.setId(id);

        var response = grupoRepository.save(grupo);

        return GrupoResponse.build(response);
    }

    @Override
    public GrupoResponse findCompleteById(Long id) {
        var grupo = grupoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return GrupoResponse.build(grupo);
    }

    @Override
    @Transactional
    public void verificaGrupos(Interesse interesse) {
        // Lógica para verificar e criar grupos com base no interesse
        List<InteresseUsuario> usuariosInteressados = interesseUsuarioService.findAllByInteresseId(interesse.getId());

        // Se houver pelo menos dois usuários com o mesmo interesse, cria um novo grupo
        if (usuariosInteressados.size() >= 2) {
            Grupo novoGrupo = new Grupo();
            novoGrupo.setInteresse(interesse);
            var savedGrupo = grupoRepository.save(novoGrupo);

            // Associa os usuários ao novo grupo na tabela UsuarioGrupo
            usuariosInteressados.forEach(u -> {
                usuarioGrupoService.save(u.getUsuario(), savedGrupo);
            });
        }
    }

    @Override
    public void deleteById(Long id) {
        existsById(id);
        grupoRepository.deleteById(id);
    }

    private void existsById(Long id) {
        if (!grupoRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
    }
}
