package logic.component.template.server.service;

import logic.component.template.server.repository.EmpresaRepository;
import logic.component.template.shared.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    @Cacheable(value = "getAllEmpresa", key = "'" + "getAllEmpresa" + "' + #id")
    public List<Empresa> getAllEmpresa(){
        return empresaRepository.findAll();
    }

    @Caching(put = {@CachePut(value = "getAllEmpresa", key = "'" + "getAllEmpresa" + "' + #empresa.id")},
            evict = {@CacheEvict(value = "getAllEmpresa", key = "'" + "getAllEmpresa" + "' + #empresa.id", allEntries = true),
                    @CacheEvict(value = "getByIdEmpresa", key = "'" + "getByIdEmpresa" + "' + #empresa.id", allEntries = true)})
    public Empresa insertEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    @Cacheable(value = "getByIdEmpresa", key = "'" + "getByIdEmpresa" + "' + #id")
    public Empresa getByIdEmpresa(Long id){
        return empresaRepository.findById(id).orElseThrow(() -> new NullPointerException());
    }
}
