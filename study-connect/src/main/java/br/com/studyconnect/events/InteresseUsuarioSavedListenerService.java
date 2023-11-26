package br.com.studyconnect.events;

import br.com.studyconnect.model.Grupo;
import br.com.studyconnect.model.InteresseUsuario;
import br.com.studyconnect.model.Usuario;
import br.com.studyconnect.model.UsuarioGrupo;
import br.com.studyconnect.service.GrupoService;
import br.com.studyconnect.service.NotificacaoService;
import br.com.studyconnect.service.UsuarioGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteresseUsuarioSavedListenerService implements ApplicationListener<InteresseUsuarioSavedEvent> {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private UsuarioGrupoService usuarioGrupoService;

    @Autowired
    private NotificacaoService notificacaoService;

    @Override
    public void onApplicationEvent(InteresseUsuarioSavedEvent event) {
        InteresseUsuario interesseUsuario = (InteresseUsuario) event.getSource();

        // Lógica para verificar e criar grupos
        Grupo novoGrupo = grupoService.verificaGrupos(interesseUsuario.getInteresse(), interesseUsuario.getUsuario());

        // Se o grupo foi criado, notifique os usuários
        if (novoGrupo != null) {
            notificarUsuariosNoGrupo(novoGrupo);
        }
    }

    private void notificarUsuariosNoGrupo(Grupo grupo) {
        //List<UsuarioGrupo> usuarioGrupos = grupo.getUsuarioGrupos();
        List<UsuarioGrupo> usuarioGrupos = usuarioGrupoService.findAllByGrupoId(grupo.getId());

        for (UsuarioGrupo usuarioGrupo : usuarioGrupos) {
            Usuario usuario = usuarioGrupo.getUsuario();
            notificacaoService.enviarNotificacao(usuario.getId(), "Você foi adicionado a um novo grupo!");
        }
    }
}
