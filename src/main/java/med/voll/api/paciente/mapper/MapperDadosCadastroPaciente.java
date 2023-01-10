package med.voll.api.paciente.mapper;

import med.voll.api.paciente.dto.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperDadosCadastroPaciente {
    Paciente toEntity(DadosCadastroPaciente dto);

    DadosCadastroPaciente toDto(Paciente entity);

    List<DadosCadastroPaciente> toListDto(List<Paciente> entity);

    List<Paciente> toListEntity(List<DadosCadastroPaciente> entity);
}
