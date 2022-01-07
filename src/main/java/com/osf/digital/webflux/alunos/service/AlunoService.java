package com.osf.digital.webflux.alunos.service;

import com.osf.digital.webflux.alunos.model.Aluno;
import com.osf.digital.webflux.alunos.repository.AlunoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@Transactional
public class AlunoService {

    @Autowired
    public AlunoRepository alunoRepository;

    public Mono<Aluno> create(Aluno aluno){
       return alunoRepository.save(aluno);
    }

    public Flux<Aluno> getAll(){
        return alunoRepository.findAll();
    }

    public Mono<Aluno> update(Long id,  Aluno aluno){
        return alunoRepository.findById(id)
                .flatMap(dbAluno -> {
                    dbAluno.setNome(aluno.getNome());
                    dbAluno.setIdade(aluno.getIdade());
                    dbAluno.setSerie(aluno.getSerie());
                    return alunoRepository.save(dbAluno);
                });
    }

    public Mono<Aluno> delete(Long id){
        return alunoRepository.findById(id)
                .flatMap(existingAluno -> alunoRepository.delete(existingAluno)
                        .then(Mono.just(existingAluno)));
    }
}
