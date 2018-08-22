package logic.component.template.server.converter;

import logic.component.template.shared.dto.FuncionarioDto;
import logic.component.template.shared.model.Funcionario;
import org.springframework.core.convert.converter.Converter;

public class FuncionarioDTOToFuncionarioConverter implements Converter<FuncionarioDto, Funcionario> {

    @Override
    public Funcionario convert(FuncionarioDto funcionarioDto) {
        return new Funcionario()
                .setId(funcionarioDto.getId())
                .setNome(funcionarioDto.getNome())
                .setEmail(funcionarioDto.getEmail())
                .setTelefone(funcionarioDto.getTelefone());
    }
}
