package br.com.studyconnect.controller;

import br.com.studyconnect.dto.InteresseUsuarioRequest;
import br.com.studyconnect.dto.InteresseUsuarioResponse;
import br.com.studyconnect.service.InteresseUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("{id}")
    public ResponseEntity<InteresseUsuarioResponse> update(@PathVariable Long id,
                                                  @RequestBody InteresseUsuarioRequest request) {
        var interesseUsuario = interesseUsuarioService.update(id, request);
        return ResponseEntity.ok().body(interesseUsuario);
    }

    @GetMapping("{id}")
    public ResponseEntity<InteresseUsuarioResponse> findCompleteById(@PathVariable Long id) {
        var usuario = interesseUsuarioService.findCompleteById(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        interesseUsuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
