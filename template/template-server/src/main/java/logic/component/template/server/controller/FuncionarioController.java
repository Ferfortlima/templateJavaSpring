package logic.component.template.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import logic.component.template.client.FuncionarioContract;
import logic.component.template.server.service.FuncionarioService;
import logic.component.template.shared.dto.FuncionarioDto;
import logic.component.template.shared.model.Envelope;
import logic.component.template.shared.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "Funcionario")
@RestController
public class FuncionarioController implements FuncionarioContract {

    @Autowired
    FuncionarioService funcionarioService;


    @Autowired
    private ConversionService conversionService;

    @ApiOperation(value = "Busca funcionario pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Envelope getByidFuncionario(@PathVariable Long id) throws Exception {
        return new Envelope().setData(funcionarioService.getByIdFuncionario(id));
    }

    @ApiOperation(value = "Persiste um funcionario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Envelope insertFuncionario(@RequestBody FuncionarioDto funcionarioDto) throws Exception {
        Funcionario funcionario = conversionService.convert(funcionarioDto, Funcionario.class);
        return new Envelope().setData(funcionarioService.insertFuncionario(funcionario));
    }

    @ApiOperation(value = "Busca todos os funcionario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Envelope getAllFuncionario() {
        return new Envelope().setData(funcionarioService.getAllFuncionario());
    }
}