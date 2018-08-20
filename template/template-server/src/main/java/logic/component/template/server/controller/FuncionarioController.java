package logic.component.template.server.controller;

import logic.component.template.client.FuncionarioContract;
import logic.component.template.server.service.FuncionarioService;
import logic.component.template.shared.model.Envelope;
import logic.component.template.shared.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController implements FuncionarioContract {

    @Autowired
    FuncionarioService funcionarioService;

    @Override
    public Envelope getByidFuncionario(@PathVariable Long id) throws Exception {
        return new Envelope().setData(funcionarioService.getByIdFuncionario(id));
    }

    @Override
    public Envelope insertFuncionario(@RequestBody Funcionario funcionario) throws Exception {
        return new Envelope().setData(funcionarioService.insertFuncionario(funcionario));
    }

    @Override
    public Envelope getAllFuncionario() {
        return new Envelope().setData(funcionarioService.getAllFuncionario());
    }
}