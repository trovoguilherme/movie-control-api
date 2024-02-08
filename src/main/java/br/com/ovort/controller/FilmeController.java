package br.com.ovort.controller;

import br.com.ovort.dto.request.filme.FilmeRequest;
import br.com.ovort.dto.response.FilmeResponse;
import br.com.ovort.exception.NotFoundException;
import br.com.ovort.service.FilmeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/filme")
public class FilmeController {

    private final FilmeService filmeService;

    @PostMapping
    public ResponseEntity<FilmeResponse> create(@RequestBody @Valid FilmeRequest filmeRequest) throws NotFoundException {
        var filme = filmeService.create(filmeRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filme.getId()).toUri();

        return ResponseEntity.created(location).body(FilmeResponse.from(filme));
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponse>> findAll() {
        return ResponseEntity.ok(filmeService.findAll().stream().map(FilmeResponse::from).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponse> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(FilmeResponse.from(filmeService.findById(id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FilmeResponse> updateNotaOrComentario(@PathVariable("id") Integer id,
                                                                @RequestParam(name = "nota", required = false) Double nota,
                                                                @RequestParam(name = "comentario", required = false) String comentario) {
        return ResponseEntity.ok(FilmeResponse.from(filmeService.patchNotaOrComentario(id, nota, comentario)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        filmeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
