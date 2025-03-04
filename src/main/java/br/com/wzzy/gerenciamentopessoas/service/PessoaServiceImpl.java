package br.com.wzzy.gerenciamentopessoas.service;

import br.com.wzzy.gerenciamentopessoas.model.ContatoModel;
import br.com.wzzy.gerenciamentopessoas.model.EnderecoModel;
import br.com.wzzy.gerenciamentopessoas.model.PessoaModel;
import br.com.wzzy.gerenciamentopessoas.repository.ContatoRepository;
import br.com.wzzy.gerenciamentopessoas.repository.EnderecoRepository;
import br.com.wzzy.gerenciamentopessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;
    private final ContatoRepository contatoRepository;


    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository, ContatoRepository contatoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
        this.contatoRepository = contatoRepository;
    }

    /*
     * O método cadastrarPessoa recebe um objeto PessoaModel contendo os dados da pessoa a ser cadastrada.
     * Primeiro, salvamos o objeto ContatoModel associado à pessoa no banco de dados usando contatoRepository.save.
     * Em seguida, salvamos o objeto EnderecoModel associado à pessoa no banco de dados usando enderecoRepository.save.
     * Após salvar os objetos ContatoModel e EnderecoModel, associamos esses objetos salvos ao objeto PessoaModel.
     * Finalmente, salvamos o objeto PessoaModel no banco de dados usando pessoaRepository.save e retornamos o objeto salvo.
     */
    @Override
    public PessoaModel cadastrarPessoa(PessoaModel pessoaModel) {
        // Salva o contato associado à pessoa
        ContatoModel contatoModel = contatoRepository.save(pessoaModel.getContatoModel());
        // Salva o endereço associado à pessoa
        EnderecoModel enderecoModel = enderecoRepository.save(pessoaModel.getEnderecoModel());
        // Associa os objetos salvos ao objeto PessoaModel
        pessoaModel.setContatoModel(contatoModel);
        pessoaModel.setEnderecoModel(enderecoModel);
        // Salva o objeto PessoaModel no banco de dados e retorna o objeto salvo
        return pessoaRepository.save(pessoaModel);
    }

    @Override
    public PessoaModel atualizarPessoa(PessoaModel pessoaModel) {
        ContatoModel contatoModel = contatoRepository.save(pessoaModel.getContatoModel());
        EnderecoModel enderecoModel = enderecoRepository.save(pessoaModel.getEnderecoModel());

        pessoaModel.setContatoModel(contatoModel);
        pessoaModel.setEnderecoModel(enderecoModel);

        return pessoaRepository.save(pessoaModel);
    }

    @Override
    public List<PessoaModel> listarPessoa() {
        return pessoaRepository.findAll();
    }

    @Override
    public PessoaModel buscarPessoaPorIdPessoa(Long idPessoa) {
        return pessoaRepository.findByIdPessoa(idPessoa);
    }


}