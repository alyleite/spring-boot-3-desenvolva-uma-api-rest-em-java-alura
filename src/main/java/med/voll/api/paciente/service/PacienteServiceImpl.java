package med.voll.api.paciente.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import med.voll.api.medico.dto.DadosAtualizacaoMedico;
import med.voll.api.paciente.PacienteRepository;
import med.voll.api.paciente.dto.DadosAtualizacaoPaciente;
import med.voll.api.paciente.dto.DadosCadastroPaciente;
import med.voll.api.paciente.dto.DadosListagemPaciente;
import med.voll.api.paciente.mapper.MapperDadosCadastroPaciente;
import med.voll.api.paciente.mapper.MapperDadosListagemPaciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository repository;
    private final MapperDadosCadastroPaciente mapper;
    private final MapperDadosListagemPaciente mapperDadosListagemPaciente;

    @Override
    @Transactional
    public void cadastrar(DadosCadastroPaciente dados) {
        repository.save(mapper.toEntity(dados));
    }

    @Override
    public Page<DadosListagemPaciente> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(mapperDadosListagemPaciente::toDto);
    }

    @Override
    @Transactional
    public void atualizar(DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
