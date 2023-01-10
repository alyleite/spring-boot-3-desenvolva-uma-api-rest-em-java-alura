package med.voll.api.medico.dto;

import med.voll.api.medico.Especialidade;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
}
