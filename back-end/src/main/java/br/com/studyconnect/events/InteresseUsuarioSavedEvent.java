package br.com.studyconnect.events;

import br.com.studyconnect.model.InteresseUsuario;
import org.springframework.context.ApplicationEvent;

public class InteresseUsuarioSavedEvent extends ApplicationEvent {

    public InteresseUsuarioSavedEvent(InteresseUsuario source) {
        super(source);
    }
}