package med.voll.api.paciente;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import med.voll.api.controller.BaseController;
import med.voll.api.paciente.dto.DadosAtualizacaoPaciente;
import med.voll.api.paciente.dto.DadosCadastroPaciente;
import med.voll.api.paciente.dto.DadosListagemPaciente;
import med.voll.api.paciente.service.PacienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
@AllArgsConstructor
@Slf4j
public class PacienteController extends BaseController {

    private final PacienteService service;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente json) {
        log.info(json.toString());
        service.cadastrar(json);
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return service.listar(paginacao);
    }

    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente json) {
        log.info(json.toString());
        service.atualizar(json);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
