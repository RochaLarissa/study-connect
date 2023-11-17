package br.com.studyconnect.events;

import br.com.studyconnect.model.InteresseUsuario;
import br.com.studyconnect.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class InteresseUsuarioSavedListenerService implements ApplicationListener<InteresseUsuarioSavedEvent> {

    @Autowired
    private GrupoService grupoService;

    @Override
    public void onApplicationEvent(InteresseUsuarioSavedEvent event) {
        InteresseUsuario interesseUsuario = (InteresseUsuario) event.getSource();

        // Lógica para verificar e criar grupos
        grupoService.verificaGrupos(interesseUsuario.getInteresse());
    }
}
