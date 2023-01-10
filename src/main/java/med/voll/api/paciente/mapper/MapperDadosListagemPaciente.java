package med.voll.api.paciente.mapper;

import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.dto.DadosListagemPaciente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperDadosListagemPaciente {
    Paciente toEntity(DadosListagemPaciente dto);

    DadosListagemPaciente toDto(Paciente entity);

    List<DadosListagemPaciente> toListDto(List<Paciente> entity);

    List<Paciente> toListEntity(List<DadosListagemPaciente> entity);
}
