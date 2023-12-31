package br.com.studyconnect.service.impl;

import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.Usuario;
import br.com.studyconnect.model.UsuarioGrupo;
import br.com.studyconnect.repository.UsuarioGrupoRepository;
import br.com.studyconnect.service.UsuarioGrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioGrupoServiceImpl implements UsuarioGrupoService {

    private final UsuarioGrupoRepository usuarioGrupoRepository;

    @Override
    public void save(Usuario usuario, Grupo grupo) {
        UsuarioGrupo usuarioGrupo = new UsuarioGrupo();
        usuarioGrupo.setUsuario(usuario);
        usuarioGrupo.setGrupo(grupo);

        usuarioGrupoRepository.save(usuarioGrupo);
    }

    @Override
    public void update(Long usuarioId, Long grupoId) {
        UsuarioGrupo usuarioGrupo = new UsuarioGrupo();
        usuarioGrupo.setUsuario(Usuario.build(usuarioId));
        usuarioGrupo.setGrupo(Grupo.build(grupoId));

        usuarioGrupoRepository.save(usuarioGrupo);
    }

    @Override
    public List<UsuarioGrupo> findAllByUsuarioId(Long usuarioId) {
        return usuarioGrupoRepository.findAllByUsuarioId(usuarioId);
    }

    @Override
    public List<UsuarioGrupo> findAllByGrupoId(Long grupoId) {
        return usuarioGrupoRepository.findAllByGrupoId(grupoId);
    }

    @Override
    public Boolean existsByUsuarioAndGrupo(Long usuarioId, Long grupoId) {
        return usuarioGrupoRepository.existsByUsuarioIdAndGrupoId(usuarioId, grupoId);
    }

}
