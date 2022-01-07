package com.osf.digital.webflux.alunos.repository;

import com.osf.digital.webflux.alunos.model.Aluno;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AlunoRepository extends ReactiveCrudRepository<Aluno,Long> {
}
