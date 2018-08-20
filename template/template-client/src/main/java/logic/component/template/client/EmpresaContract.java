package logic.component.template.client;

import logic.component.template.shared.model.Empresa;
import logic.component.template.shared.model.Envelope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmpresaContract {
    @GetMapping("empresa/{id}")
    Envelope getByidEmpresa(@PathVariable Long id) throws Exception;

    @PostMapping("empresa")
    Envelope<Empresa> insertEmpresa(@RequestBody Empresa empresa) throws Exception;

    @GetMapping("empresa/listEmpresa")
    Envelope getAllEmpresa();
}
