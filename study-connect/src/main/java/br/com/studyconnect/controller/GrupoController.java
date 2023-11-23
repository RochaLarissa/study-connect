package br.com.studyconnect.controller;

import br.com.studyconnect.dto.GrupoRequest;
import br.com.studyconnect.dto.GrupoResponse;
import br.com.studyconnect.service.GrupoService;
import br.com.studyconnect.service.UsuarioGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private UsuarioGrupoService usuarioGrupoService;

    @PostMapping("{grupoId}/{usuarioId}")
    public ResponseEntity<Void> addNovoUsuarioAoGrupo(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
        usuarioGrupoService.update(usuarioId, grupoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("{grupoId}")
    public ResponseEntity<GrupoResponse> update(@PathVariable Long grupoId, @RequestBody GrupoRequest request) {
        var grupo = grupoService.update(grupoId, request);
        return ResponseEntity.ok().body(grupo);
    }

    @GetMapping("{grupoId}")
    public ResponseEntity<GrupoResponse> findCompleteById(@PathVariable Long grupoId) {
        var grupo = grupoService.findCompleteById(grupoId);
        return ResponseEntity.ok(grupo);
    }

    @GetMapping("{usuarioId}")
    public ResponseEntity<GrupoResponse> findAllGruposByUsuarioId(@PathVariable Long usuarioId) {
        var grupo = grupoService.findAllGruposByUsuarioId(usuarioId);
        return ResponseEntity.ok(grupo);
    }

}
