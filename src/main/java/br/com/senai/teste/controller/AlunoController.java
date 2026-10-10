package br.com.senai.teste.controller;

import br.com.senai.teste.model.Aluno;
import br.com.senai.teste.sevice.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno) {

        Aluno alunoCadastrado = alunoService.cadastrar(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        List<Aluno> alunos = alunoService.listar();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(
            @PathVariable Integer id) {

        Optional<Aluno> aluno = alunoService.buscarPorId(id);
        if (aluno.isPresent()) {
            return ResponseEntity.ok(aluno.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}") // Aproveite para corrigir o mapeamento do ID aqui também!
    public ResponseEntity<Aluno> atualizar(
            @PathVariable Integer id,
            @RequestBody Aluno novosDados) {
        Optional<Aluno> alunoAtualizado = alunoService.atualizar(id, novosDados);

        if (alunoAtualizado.isPresent()) {
            return ResponseEntity.ok(alunoAtualizado.get());
        } // <- Esta chave fecha apenas o bloco do "if"

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Integer id) {

        boolean excluido = alunoService.excluir(id);

        if (excluido) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}