package br.com.studyconnect.controller;

import br.com.studyconnect.dto.InteresseUsuarioRequest;
import br.com.studyconnect.dto.InteresseUsuarioResponse;
import br.com.studyconnect.service.InteresseUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interesses-usuarios")
public class InteresseUsuarioController {
    @Autowired
    private InteresseUsuarioService interesseUsuarioService;

    @PostMapping
    public ResponseEntity<InteresseUsuarioResponse> save(@RequestBody InteresseUsuarioRequest request) {
        var usuario = interesseUsuarioService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("{usuarioId}")
    public ResponseEntity<List<InteresseUsuarioResponse>> findAll(@PathVariable Long usuarioId) {
        var interessesUsuario = InteresseUsuarioResponse.build(interesseUsuarioService.findAllByUsuarioId(usuarioId));
        return ResponseEntity.ok(interessesUsuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        interesseUsuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
