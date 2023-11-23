package br.com.studyconnect.service;

import br.com.studyconnect.model.Notificacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void enviarNotificacao(Long usuarioId, String mensagem) {
        // Notificar o usuário em tempo real
        String destino = "/topic/notificacoes/" + usuarioId;
        messagingTemplate.convertAndSend(destino, new Notificacao(mensagem));
    }
}
