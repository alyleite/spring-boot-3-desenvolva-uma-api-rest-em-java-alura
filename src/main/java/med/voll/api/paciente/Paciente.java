package med.voll.api.paciente;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.converter.BooleanNotNullConverter;
import med.voll.api.endereco.Endereco;
import med.voll.api.model.AbstractEntity;
import med.voll.api.paciente.dto.DadosAtualizacaoPaciente;
import org.hibernate.Hibernate;

import java.util.Objects;

@Table(name = "paciente")
@Entity(name = "Paciente")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    @NotNull
    @Column(name = "ativo", nullable = false)
    @Convert(converter = BooleanNotNullConverter.class)
    private Boolean ativo;

    @Override
    public Long getId() {
        return this.id;
    }

    public void excluir() {
        this.ativo = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Paciente entity = (Paciente) o;
        return id != null && Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();
        if (dados.telefone() != null)
            this.telefone = dados.telefone();
        if (dados.endereco() != null)
            this.endereco.atualizarInformacoes(dados.endereco());
    }
}
