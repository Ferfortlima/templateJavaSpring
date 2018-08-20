package logic.component.template.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "funcionario-service", path = "/funcionario")
public class FuncionarioClient {
}
