package logic.component.template.server.converter;

import logic.component.template.shared.dto.EmpresaDto;
import logic.component.template.shared.model.Empresa;
import org.springframework.core.convert.converter.Converter;

public class EmpresaDTOToEmpresaConverter implements Converter<EmpresaDto, Empresa> {

    @Override
    public Empresa convert(EmpresaDto empresaDto) {
        return new Empresa()
                .setId(empresaDto.getId())
                .setNome(empresaDto.getNome())
                .setCnpj(empresaDto.getCnpj());
    }
}
