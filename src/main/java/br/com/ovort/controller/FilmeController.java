package br.com.ovort.controller;

import br.com.ovort.dto.request.filme.FilmeRequest;
import br.com.ovort.dto.response.FilmeResponse;
import br.com.ovort.exception.NotFoundException;
import br.com.ovort.service.FilmeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/filme")
public class FilmeController {

    private final FilmeService filmeService;

    @PostMapping
    public ResponseEntity<FilmeResponse> create(@RequestBody @Valid FilmeRequest filmeRequest) throws NotFoundException {
        return ResponseEntity.ok(FilmeResponse.from(filmeService.create(filmeRequest)));
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponse>> findAll() {
        return ResponseEntity.ok(filmeService.findAll().stream().map(FilmeResponse::from).toList());
    }

}
