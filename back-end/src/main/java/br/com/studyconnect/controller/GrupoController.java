package br.com.studyconnect.controller;

import br.com.studyconnect.dto.GrupoDetalheResponse;
import br.com.studyconnect.dto.GrupoRequest;
import br.com.studyconnect.dto.GrupoResponse;
import br.com.studyconnect.service.GrupoService;
import br.com.studyconnect.service.UsuarioGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private UsuarioGrupoService usuarioGrupoService;

    @PostMapping("grupo-id/{grupoId}/usuario-id/{usuarioId}")
    public ResponseEntity<Void> addNovoUsuarioAoGrupo(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
        usuarioGrupoService.update(usuarioId, grupoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("{grupoId}")
    public ResponseEntity<GrupoResponse> updateDescricao(@PathVariable Long grupoId, @RequestBody GrupoRequest request) {
        var grupo = grupoService.update(grupoId, request);
        return ResponseEntity.ok().body(grupo);
    }

    @GetMapping("grupo-id/{grupoId}")
    public ResponseEntity<GrupoDetalheResponse> findCompleteById(@PathVariable Long grupoId) {
        var grupo = grupoService.findCompleteById(grupoId);
        return ResponseEntity.ok(grupo);
    }

    @GetMapping("usuario-id/{usuarioId}")
    public ResponseEntity<List<GrupoResponse>> findAllGruposByUsuarioId(@PathVariable Long usuarioId) {
        var grupo = grupoService.findAllGruposByUsuarioId(usuarioId);
        return ResponseEntity.ok(grupo);
    }

    @GetMapping
    public ResponseEntity<List<GrupoResponse>> findAll() {
        var grupo = grupoService.findAllGrupos();
        return ResponseEntity.ok(grupo);
    }

}
