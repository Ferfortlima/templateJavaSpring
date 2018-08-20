package logic.component.template.client;

import logic.component.template.shared.model.Envelope;
import logic.component.template.shared.model.Funcionario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FuncionarioContract {

    @GetMapping("funcionario/{id}")
    Envelope getByidFuncionario(@PathVariable Long id) throws Exception;

    @PostMapping("funcionario")
    Envelope insertFuncionario(@RequestBody Funcionario funcionario) throws Exception;

    @GetMapping("funcionario/listFuncionario")
    Envelope getAllFuncionario();


}
