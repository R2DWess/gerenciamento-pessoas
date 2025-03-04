package br.com.wzzy.gerenciamentopessoas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
@NoArgsConstructor
public class PessoaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    @NotBlank(message = "O campo nome está incorreto")
    private String nome;

    @NotBlank(message = "O campo idade está incorreto")
    private String idade;

    @ManyToOne
    @JoinColumn(name = "contato_model_id_contato")
    private ContatoModel contatoModel;

    @ManyToOne
    @JoinColumn(name = "endereco_model_id_endereco")
    private EnderecoModel enderecoModel;

}
