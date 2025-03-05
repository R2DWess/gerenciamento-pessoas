package br.com.wzzy.gerenciamentopessoas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dados_pessoais")
public class DadosPessoaisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDadosPessoais;

    @NotBlank(message = "O campo nome está incorreto")
    private String nome;

    @NotBlank(message = "O campo idade está incorreto")
    private String idade;

    @CPF(message = "O campo cpf está incorreto")
    private String cpf;

    @NotBlank(message = "O campo sexo está incorreto")
    private String sexo;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "O campo data de nascimento está incorreto")
    private String dataNascimento;
}
