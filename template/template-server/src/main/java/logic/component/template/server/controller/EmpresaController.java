package logic.component.template.server.controller;

import io.swagger.annotations.*;
import logic.component.template.client.EmpresaContract;
import logic.component.template.server.service.EmpresaService;
import logic.component.template.shared.model.Empresa;
import logic.component.template.shared.model.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "Empresa")
@RestController
public class EmpresaController implements EmpresaContract {

    @Autowired
    EmpresaService empresaService;

    @ApiOperation(value = "Busca empresa pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Envelope getByidEmpresa(@PathVariable Long id) throws Exception {
        return new Envelope().setData(empresaService.getByIdEmpresa(id));
    }

    @ApiOperation(value = "Persiste uma empresa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Envelope insertEmpresa(@RequestBody Empresa empresa) throws Exception {
        return new Envelope().setData(empresaService.insertEmpresa(empresa));
    }

    @ApiOperation(value = "Busca todas as empresas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Envelope getAllEmpresa() {
        return new Envelope().setData(empresaService.getAllEmpresa());
    }
}
