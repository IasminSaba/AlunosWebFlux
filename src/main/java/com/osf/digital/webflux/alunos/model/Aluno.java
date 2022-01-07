package com.osf.digital.webflux.alunos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("alunos")
public class Aluno {

    @Id
    private Long id;
    private String nome;
    private String idade;
    private String serie;

    public Aluno(String nome, String idade, String serie) {
        this.nome = nome;
        this.idade = idade;
        this.serie = serie;
    }
}
