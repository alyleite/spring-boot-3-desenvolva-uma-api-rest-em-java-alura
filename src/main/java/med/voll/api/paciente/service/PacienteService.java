package med.voll.api.paciente.service;

import med.voll.api.paciente.dto.DadosAtualizacaoPaciente;
import med.voll.api.paciente.dto.DadosCadastroPaciente;
import med.voll.api.paciente.dto.DadosListagemPaciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PacienteService {
    void cadastrar(DadosCadastroPaciente dados);

    Page<DadosListagemPaciente> listar(Pageable paginacao);

    void atualizar(DadosAtualizacaoPaciente dados);

    void excluir(Long id);
}
