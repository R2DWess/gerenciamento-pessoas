package br.com.wzzy.gerenciamentopessoas.controller;

import br.com.wzzy.gerenciamentopessoas.exception.PessoaCadastradoException;
import br.com.wzzy.gerenciamentopessoas.model.PessoaModel;
import br.com.wzzy.gerenciamentopessoas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaModel> cadastrarPessoa(@RequestBody PessoaModel pessoaModel) {

            PessoaModel novaPessoa = pessoaService.cadastrarPessoa(pessoaModel);
            return new ResponseEntity<>(novaPessoa, HttpStatus.CREATED);
        }


    @PatchMapping("/atualizar-pessoa/{idPessoa}")
    public PessoaModel atualizarPessoa(@PathVariable Long idPessoa,
                                                       @RequestBody PessoaModel pessoaModel) {

            return pessoaService.atualizarPessoa(idPessoa, pessoaModel);
        }


    @GetMapping("/listar-pessoa")
    public List<PessoaModel> listarPessoa() {
        return pessoaService.listarPessoa();
    }

    @GetMapping("/buscar-id/{idPessoa}")
    public ResponseEntity<PessoaModel> buscarPessoaPorIdPessoa(@PathVariable Long idPessoa) {
        try {
            PessoaModel pessoaEncontradaPorId = pessoaService.buscarPessoaPorIdPessoa(idPessoa);
            return new ResponseEntity<>(pessoaEncontradaPorId, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletar-pessoa/{idPessoa}")
    public String deletarPessoa(@PathVariable Long idPessoa) {
        try {
            pessoaService.deletarPessoa(idPessoa);
            return "Pessoa com ID " + idPessoa + " deletado com sucesso.";
        } catch (RuntimeException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping("/deletar-pessoa")
    public void deletarTodos() {
            pessoaService.deletarTodos();

    }


    @GetMapping("/buscar-nome/{nome}")
    public ResponseEntity<List<PessoaModel>> buscarPessoaPorNome(@PathVariable String nome) {
        try {
            List<PessoaModel> pessoaEncontradaPorNome = pessoaService.buscarPessoaPorNome(nome);
            return new ResponseEntity<>(pessoaEncontradaPorNome, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar-cpf/{cpf}")
    public ResponseEntity<Optional<PessoaModel>> buscarPessoaPorCpf(@PathVariable String cpf) {
        try {
            Optional<PessoaModel> pessoaEncontradaPorCpf = pessoaService.buscarPessoaPorCpf(cpf);
            return new ResponseEntity<>(pessoaEncontradaPorCpf, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}