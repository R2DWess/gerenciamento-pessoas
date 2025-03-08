package br.com.wzzy.gerenciamentopessoas.service;

import br.com.wzzy.gerenciamentopessoas.exception.PessoaCadastradoException;
import br.com.wzzy.gerenciamentopessoas.model.ContatoModel;
import br.com.wzzy.gerenciamentopessoas.model.DadosPessoaisModel;
import br.com.wzzy.gerenciamentopessoas.model.EnderecoModel;
import br.com.wzzy.gerenciamentopessoas.model.PessoaModel;
import br.com.wzzy.gerenciamentopessoas.repository.ContatoRepository;
import br.com.wzzy.gerenciamentopessoas.repository.DadosPessoaisRepository;
import br.com.wzzy.gerenciamentopessoas.repository.EnderecoRepository;
import br.com.wzzy.gerenciamentopessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;
    private final ContatoRepository contatoRepository;
    private final DadosPessoaisRepository dadosPessoaisRepository;


    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository, ContatoRepository contatoRepository, DadosPessoaisRepository dadosPessoaisRepository) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
        this.contatoRepository = contatoRepository;
        this.dadosPessoaisRepository = dadosPessoaisRepository;
    }

    private PessoaModel getPessoaModel(PessoaModel pessoaModel) {
        ContatoModel contatoModel = contatoRepository.save(pessoaModel.getContatoModel());
        EnderecoModel enderecoModel = enderecoRepository.save(pessoaModel.getEnderecoModel());
        DadosPessoaisModel dadosPessoaisModel = dadosPessoaisRepository.save(pessoaModel.getDadosPessoaisModel());

        pessoaModel.setContatoModel(contatoModel);
        pessoaModel.setEnderecoModel(enderecoModel);
        pessoaModel.setDadosPessoaisModel(dadosPessoaisModel);

        return pessoaRepository.save(pessoaModel);
    }

    private List<PessoaModel> recuperarNomePessoa(String nome) {
        return pessoaRepository.findByDadosPessoaisModel_Nome(nome);
    }

    private Optional<PessoaModel> recuperarCpfPessoa(String cpf) {
        return pessoaRepository.findByDadosPessoaisModel_Cpf(cpf);
    }

    private PessoaModel recuperarIdPessoa(Long idPessoa) {
        return pessoaRepository.findByIdPessoa(idPessoa);
    }

    @Override
    public PessoaModel cadastrarPessoa(PessoaModel pessoaModel) {
        return tratativarParaCadastrarPessoa(pessoaModel).getBody();
    }

    @Override
    public ResponseEntity<PessoaModel> tratativarParaCadastrarPessoa(PessoaModel pessoaModel) {
        Optional<PessoaModel> cpfCadastrado = pessoaRepository.findByDadosPessoaisModel_Cpf(
                pessoaModel.getDadosPessoaisModel().getCpf()
        );

        if (cpfCadastrado.isPresent()) {
            throw new PessoaCadastradoException("Pessoa já cadastrado!");
        }

        PessoaModel pessoaSalva = pessoaRepository.save(pessoaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaModel);
    }

    @Override
    public PessoaModel atualizarPessoa(Long idPessoa, PessoaModel pessoaModel) {
        PessoaModel pessoaExistente = recuperarIdPessoa(idPessoa);

        if (pessoaExistente == null) {
            throw new RuntimeException("Pessoa com ID " + idPessoa + " não encontrada para atualização");
        }

        return getPessoaModel(pessoaModel);
    }

    @Override
    public ResponseEntity<PessoaModel> tratativarParaAtualizarPessoa(Long idPessoa, PessoaModel pessoaModel) {
        Optional<PessoaModel> idEncontraro = Optional.ofNullable(pessoaRepository.findByIdPessoa(
                pessoaModel.getIdPessoa()
        ));

        if (idEncontraro.isPresent()) {
            PessoaModel pessoaSalva = pessoaRepository.save(pessoaModel);
        }

        throw new PessoaCadastradoException("Pessoa com o id " + pessoaModel.getIdPessoa() + " não encontrado");
    }

    @Override
    public List<PessoaModel> listarPessoa() {
        return pessoaRepository.findAll();
    }

    @Transactional
    @Override
    public void deletarTodos() {
        pessoaRepository.deleteAll();
    }


    @Override
    @Transactional
    public void deletarPessoa(Long idPessoa) {
        if (pessoaRepository.existsByIdPessoa(idPessoa)) {
            pessoaRepository.deleteByIdPessoa(idPessoa);
        } else {
            throw new RuntimeException("Pessoa com id " + idPessoa + " não encontrado.");
        }
    }

    @Override
    public PessoaModel buscarPessoaPorIdPessoa(Long idPessoa) {
        return recuperarIdPessoa(idPessoa);
    }

    @Override
    public List<PessoaModel> buscarPessoaPorNome(String nome) {
        return recuperarNomePessoa(nome);
    }

    @Override
    public Optional<PessoaModel> buscarPessoaPorCpf(String cpf) {
        return recuperarCpfPessoa(cpf);
    }

}