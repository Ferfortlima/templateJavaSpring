package logic.component.template.server.config;

import logic.component.template.server.converter.EmpresaDTOToEmpresaConverter;
import logic.component.template.server.converter.FuncionarioDTOToFuncionarioConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {

        //Novos conversores sendo adicionados ao FormatterRegistry para que estejam disponiveis para utilizacao na aplicacao
        registry.addConverter(new FuncionarioDTOToFuncionarioConverter());
        registry.addConverter(new EmpresaDTOToEmpresaConverter());
    }
}
