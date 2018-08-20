package logic.component.template.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "empresa-service", path = "/empresa")
public interface EmpresaClient extends EmpresaContract{
}
