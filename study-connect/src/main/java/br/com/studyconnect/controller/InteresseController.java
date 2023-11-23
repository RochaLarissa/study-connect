package br.com.studyconnect.controller;

import br.com.studyconnect.dto.InteresseRequest;
import br.com.studyconnect.dto.InteresseResponse;
import br.com.studyconnect.service.InteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interesses")
public class InteresseController {
    @Autowired
    private InteresseService interesseService;

    @PostMapping
    public ResponseEntity<InteresseResponse> save(@RequestBody InteresseRequest request) {
        var interesse = interesseService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(interesse);
    }

    @PutMapping("{id}")
    public ResponseEntity<InteresseResponse> update(@PathVariable Long id,
                                                  @RequestBody InteresseRequest request) {
        var interesse = interesseService.update(id, request);
        return ResponseEntity.ok().body(interesse);
    }

    @GetMapping
    public ResponseEntity<List<InteresseResponse>> findAll() {
        var interesses = interesseService.findAll();
        return ResponseEntity.ok(interesses);
    }

    @GetMapping("{id}")
    public ResponseEntity<InteresseResponse> findCompleteById(@PathVariable Long id) {
        var interesse = interesseService.findCompleteById(id);
        return ResponseEntity.ok(interesse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        interesseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
