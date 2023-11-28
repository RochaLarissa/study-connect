package br.com.studyconnect.service.impl;

import br.com.studyconnect.dto.GrupoDetalheResponse;
import br.com.studyconnect.dto.GrupoRequest;
import br.com.studyconnect.dto.GrupoResponse;
import br.com.studyconnect.dto.UsuarioResponse;
import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.Interesse;
import br.com.studyconnect.model.InteresseUsuario;
import br.com.studyconnect.model.Usuario;
import br.com.studyconnect.repository.GrupoRepository;
import br.com.studyconnect.service.GrupoService;
import br.com.studyconnect.service.InteresseService;
import br.com.studyconnect.service.InteresseUsuarioService;
import br.com.studyconnect.service.UsuarioGrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository grupoRepository;
    private final InteresseUsuarioService interesseUsuarioService;
    private final InteresseService interesseService;
    private final UsuarioGrupoService usuarioGrupoService;

    @Override
    public GrupoResponse update(Long grupoId, GrupoRequest grupoRequest) {
        var grupo = Grupo.build(grupoRequest);
        grupo.setId(grupoId);
        grupoRepository.save(grupo);
        return GrupoResponse.build(grupo);
    }


    @Override
    public GrupoDetalheResponse findCompleteById(Long id) {
        var grupo = grupoRepository.findCompleteById(id).orElseThrow(EntityNotFoundException::new);
        var interesse = interesseService.findCompleteById(grupo.getInteresse().getId());
        var usuariosGrupo = usuarioGrupoService.findAllByGrupoId(grupo.getId());

        List<UsuarioResponse> usuarios = new ArrayList<>();
        usuariosGrupo.forEach(u -> {
            var user = UsuarioResponse.build(u.getUsuario());
            usuarios.add(user);
        });

        var response = GrupoDetalheResponse.build(grupo);
        response.setInteresse(interesse);
        response.setUsuarios(usuarios);

        return response;
    }

    @Override
    @Transactional
    public Grupo verificaGrupos(Interesse interesse, Usuario novoUsuario) {
        List<InteresseUsuario> usuariosInteressados = interesseUsuarioService.findAllByInteresseId(interesse.getId());

        if (usuariosInteressados.size() > 1) {
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
    public List<GrupoResponse> findAllGruposByUsuarioId(Long usuarioId) {
        var grupo = grupoRepository.findAllByUsuarioGruposUsuarioId(usuarioId);
        return GrupoResponse.build(grupo);
    }

    @Override
    public List<GrupoResponse> findAllGrupos() {
        var grupo = grupoRepository.findAll();
        return GrupoResponse.build(grupo);
    }

}
