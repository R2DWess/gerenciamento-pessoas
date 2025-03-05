package br.com.wzzy.gerenciamentopessoas.repository;

import br.com.wzzy.gerenciamentopessoas.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

    PessoaModel findByIdPessoa(Long idPessoa);

    void deleteByIdPessoa(Long idPessoa);

    boolean existsByIdPessoa(Long idPessoa);

    List<PessoaModel> findByDadosPessoaisModel_Nome(String nome);

    List<PessoaModel> findByDadosPessoaisModel_Cpf(String cpf);

//    List<PessoaModel> recuperarIdPessoa(Long idPessoa);

}