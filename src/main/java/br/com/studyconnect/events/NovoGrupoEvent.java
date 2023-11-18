package br.com.studyconnect.events;

import br.com.studyconnect.model.Grupo;
import org.springframework.context.ApplicationEvent;

public class NovoGrupoEvent extends ApplicationEvent {

    private final Grupo novoGrupo;

    public NovoGrupoEvent(Object source, Grupo novoGrupo) {
        super(source);
        this.novoGrupo = novoGrupo;
    }

    public Grupo getNovoGrupo() {
        return novoGrupo;
    }
}