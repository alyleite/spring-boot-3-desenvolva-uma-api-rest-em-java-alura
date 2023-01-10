package med.voll.api.medico.service;

import med.voll.api.medico.dto.DadosAtualizacaoMedico;
import med.voll.api.medico.dto.DadosCadastroMedico;
import med.voll.api.medico.dto.DadosListagemMedico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicoService {
    void cadastrar(DadosCadastroMedico dados);

    Page<DadosListagemMedico> listar(Pageable paginacao);

    void atualizar(DadosAtualizacaoMedico dados);

    void excluir(Long id);
}
