package med.voll.api.medico.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import med.voll.api.medico.MedicoRepository;
import med.voll.api.medico.dto.DadosAtualizacaoMedico;
import med.voll.api.medico.dto.DadosCadastroMedico;
import med.voll.api.medico.dto.DadosListagemMedico;
import med.voll.api.medico.mapper.MapperDadosCadastroMedico;
import med.voll.api.medico.mapper.MapperDadosListagemMedico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository repository;
    private final MapperDadosCadastroMedico mapper;
    private final MapperDadosListagemMedico mapperDadosListagemMedico;

    @Override
    @Transactional
    public void cadastrar(DadosCadastroMedico dados) {
        repository.save(mapper.toEntity(dados));
    }

    @Override
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(mapperDadosListagemMedico::toDto);
    }

    @Override
    @Transactional
    public void atualizar(DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
