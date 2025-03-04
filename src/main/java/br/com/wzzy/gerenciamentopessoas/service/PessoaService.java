package br.com.wzzy.gerenciamentopessoas.service;

import br.com.wzzy.gerenciamentopessoas.model.PessoaModel;

import java.util.List;

public interface PessoaService {
    PessoaModel cadastrarPessoa(PessoaModel pessoaModel);

    PessoaModel atualizarPessoa(PessoaModel pessoaModel);

    List<PessoaModel> listarPessoa();

    PessoaModel buscarPessoaPorIdPessoa(Long idPessoa);
}
