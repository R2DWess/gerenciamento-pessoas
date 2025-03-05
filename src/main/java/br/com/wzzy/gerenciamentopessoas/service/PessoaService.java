package br.com.wzzy.gerenciamentopessoas.service;

import br.com.wzzy.gerenciamentopessoas.model.PessoaModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PessoaService {
    PessoaModel cadastrarPessoa(PessoaModel pessoaModel);


    PessoaModel atualizarPessoa(Long idPessoa, PessoaModel pessoaModel);

    List<PessoaModel> listarPessoa();

    PessoaModel buscarPessoaPorIdPessoa(Long idPessoa);

    @Transactional
    void deletarTodos();

    void deletarPessoa(Long idPessoa);

    List<PessoaModel> buscarPessoaPorNome(String nome);

    List<PessoaModel> buscarPessoaPorCpf(String cpf);
}
