package br.com.wzzy.gerenciamentopessoas.repository;

import br.com.wzzy.gerenciamentopessoas.model.DadosPessoaisModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosPessoaisRepository extends JpaRepository<DadosPessoaisModel, Long> {
}
