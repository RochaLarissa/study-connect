package br.com.studyconnect.service.impl;

import br.com.studyconnect.dto.GrupoRequest;
import br.com.studyconnect.dto.GrupoResponse;
import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.Interesse;
import br.com.studyconnect.model.InteresseUsuario;
import br.com.studyconnect.model.Usuario;
import br.com.studyconnect.repository.GrupoRepository;
import br.com.studyconnect.service.GrupoService;
import br.com.studyconnect.service.InteresseUsuarioService;
import br.com.studyconnect.service.UsuarioGrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository grupoRepository;
    private final InteresseUsuarioService interesseUsuarioService;
    private final UsuarioGrupoService usuarioGrupoService;

    @Override
    public GrupoResponse update(Long grupoId, GrupoRequest grupoRequest) {
        var grupo = Grupo.build(grupoRequest);
        grupo.setId(grupoId);

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
    public Grupo verificaGrupos(Interesse interesse, Usuario novoUsuario) {
        //TODO:findAll pode trazer mais de 1 result
        List<InteresseUsuario> usuariosInteressados = interesseUsuarioService.findAllByInteresseId(interesse.getId());

        if (!usuariosInteressados.isEmpty()) {
            Grupo grupoExistente = grupoRepository.findByInteresseId(interesse.getId());

            if (grupoExistente != null) {
                boolean novoUsuarioPertenceAoGrupo = usuarioGrupoService.existsByUsuarioAndGrupo(novoUsuario.getId(), grupoExistente.getId());
                if (!novoUsuarioPertenceAoGrupo) {
                    usuarioGrupoService.save(novoUsuario, grupoExistente);
                }
                return grupoExistente;
            } else {
                Grupo novoGrupo = new Grupo();
                novoGrupo.setInteresse(interesse);
                var savedGrupo = grupoRepository.save(novoGrupo);

                usuarioGrupoService.save(novoUsuario, savedGrupo);

                usuariosInteressados.forEach(u -> {
                    if (!u.getUsuario().equals(novoUsuario)) {
                        usuarioGrupoService.save(u.getUsuario(), savedGrupo);
                    }
                });

                return savedGrupo;
            }
        }
        return null;
    }

    @Override
    public GrupoResponse findAllGruposByUsuarioId(Long usuarioId) {
        var grupo = grupoRepository.findByUsuarioGruposUsuarioId(usuarioId);
        return GrupoResponse.build(grupo);
    }

//    private void existsById(Long id) {
//        if (!grupoRepository.existsById(id)) {
//            throw new EntityNotFoundException();
//        }
//    }
}
