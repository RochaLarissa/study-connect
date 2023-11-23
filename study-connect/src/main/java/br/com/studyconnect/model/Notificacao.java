package br.com.studyconnect.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Notificacao {

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }
}
