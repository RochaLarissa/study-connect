package br.com.studyconnect.controller;

import br.com.studyconnect.dto.UsuarioDetalheResponse;
import br.com.studyconnect.dto.UsuarioRequest;
import br.com.studyconnect.dto.UsuarioResponse;
import br.com.studyconnect.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> save(@RequestBody UsuarioRequest request) {
        var usuario = usuarioService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable Long id,
                                                  @RequestBody UsuarioRequest request) {
        var usuario = usuarioService.update(id, request);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDetalheResponse> findCompleteById(@PathVariable Long id) {
        var usuario = usuarioService.findCompleteById(id);
        return ResponseEntity.ok(usuario);
    }
}
