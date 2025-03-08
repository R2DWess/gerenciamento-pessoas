package br.com.wzzy.gerenciamentopessoas.service;

import br.com.wzzy.gerenciamentopessoas.model.PessoaModel;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PessoaService {


    PessoaModel cadastrarPessoa(PessoaModel pessoaModel);

    ResponseEntity<PessoaModel> tratativarParaCadastrarPessoa(PessoaModel pessoaModel);

    PessoaModel atualizarPessoa(Long idPessoa, PessoaModel pessoaModel);

    ResponseEntity<PessoaModel> tratativarParaAtualizarPessoa(Long idPessoa, PessoaModel pessoaModel);

    List<PessoaModel> listarPessoa();

    PessoaModel buscarPessoaPorIdPessoa(Long idPessoa);

    @Transactional
    void deletarTodos();

    void deletarPessoa(Long idPessoa);

    List<PessoaModel> buscarPessoaPorNome(String nome);

    Optional<PessoaModel> buscarPessoaPorCpf(String cpf);
}
