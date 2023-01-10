package med.voll.api.medico.mapper;

import med.voll.api.medico.Medico;
import med.voll.api.medico.dto.DadosAtualizacaoMedico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperDadosAtualizacaoMedico {
    Medico toEntity(DadosAtualizacaoMedico dto);

    DadosAtualizacaoMedico toDto(Medico entity);

    List<DadosAtualizacaoMedico> toListDto(List<Medico> entity);

    List<Medico> toListEntity(List<DadosAtualizacaoMedico> entity);
}
