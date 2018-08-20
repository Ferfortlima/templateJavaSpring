package logic.component.template.server.controller;

import logic.component.template.client.EmpresaContract;
import logic.component.template.server.service.EmpresaService;
import logic.component.template.shared.model.Empresa;
import logic.component.template.shared.model.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController implements EmpresaContract {

    @Autowired
    EmpresaService empresaService;

    @Override
    public Envelope getByidEmpresa(@PathVariable Long id) throws Exception {
        return new Envelope().setData(empresaService.getByIdEmpresa(id));
    }

    @Override
    public Envelope insertEmpresa(@RequestBody Empresa empresa) throws Exception {
        return new Envelope().setData(empresaService.insertEmpresa(empresa));
    }

    @Override
    public Envelope getAllEmpresa() {
        return new Envelope().setData(empresaService.getAllEmpresa());
    }
}
