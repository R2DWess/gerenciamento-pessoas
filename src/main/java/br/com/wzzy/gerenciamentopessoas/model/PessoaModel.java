package br.com.wzzy.gerenciamentopessoas.model;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "dados_pessoais_model_id_dados_pessoais")
    private DadosPessoaisModel dadosPessoaisModel;

    @ManyToOne
    @JoinColumn(name = "contato_model_id_contato")
    private ContatoModel contatoModel;

    @ManyToOne
    @JoinColumn(name = "endereco_model_id_endereco")
    private EnderecoModel enderecoModel;

}
