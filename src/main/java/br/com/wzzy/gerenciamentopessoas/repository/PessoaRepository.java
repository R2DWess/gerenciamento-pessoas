package br.com.wzzy.gerenciamentopessoas.repository;

import br.com.wzzy.gerenciamentopessoas.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

    PessoaModel findByIdPessoa(Long idPessoa);

    void deleteByIdPessoa(Long idPessoa);

    PessoaModel findByNome(String nome);

    PessoaModel findByCpf(String cpf);

    boolean existsByIdPessoa(Long idPessoa);
}