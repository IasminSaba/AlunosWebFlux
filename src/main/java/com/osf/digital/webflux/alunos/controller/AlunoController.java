package com.osf.digital.webflux.alunos.controller;

import com.osf.digital.webflux.alunos.model.Aluno;
import com.osf.digital.webflux.alunos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    public AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Aluno> create(@RequestBody Aluno aluno){
        return alunoService.create(aluno);
    }

    @GetMapping
    public Flux<Aluno> getAll(){
        return alunoService.getAll();
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Aluno>> updateAluno(@PathVariable Long id, @RequestBody Aluno aluno){
        return alunoService.update(id,aluno)
                .map(updatedAluno -> ResponseEntity.ok(updatedAluno))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteAluno(@PathVariable Long id){
        return alunoService.delete(id)
                .map( r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
