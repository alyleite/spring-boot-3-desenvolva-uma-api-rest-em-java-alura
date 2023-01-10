package med.voll.api.paciente.dto;

public record DadosListagemPaciente(
        Long id,
        String nome,
        String email,
        String cpf) {
}
