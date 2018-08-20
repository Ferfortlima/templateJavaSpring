package logic.component.template.server.service;

import logic.component.template.server.repository.EmpresaRepository;
import logic.component.template.shared.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public List<Empresa> getAllEmpresa(){
        return empresaRepository.findAll();
    }

    public Empresa insertEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public Empresa getByIdEmpresa(Long id){
        return empresaRepository.findById(id).orElseThrow(() -> new NullPointerException());
    }
}
