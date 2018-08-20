package logic.component.template.server.service;

import logic.component.template.server.repository.FuncionarioRepository;
import logic.component.template.shared.model.Funcionario;
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
public class FuncionarioService {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Cacheable(value = "getAllFuncionario", key = "'" + "getAllFuncionario" + "' + #id")
    public List<Funcionario> getAllFuncionario(){
        return funcionarioRepository.findAll();
    }

    @Caching(put = {@CachePut(value = "getAllFuncionario", key = "'" + "getAllFuncionario" + "' + #funcionario.id")},
            evict = {@CacheEvict(value = "getAllFuncionario", key = "'" + "getAllFuncionario" + "' + #funcionario.id", allEntries = true),
                    @CacheEvict(value = "getByIdFuncionario", key = "'" + "getByIdFuncionario" + "' + #funcionario.id", allEntries = true)})
    public Funcionario insertFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @Cacheable(value = "getByIdFuncionario", key = "'" + "getByIdFuncionario" + "' + #id")
    public Funcionario getByIdFuncionario(Long id){
        return funcionarioRepository.findById(id).orElseThrow(() -> new NullPointerException());
    }
}
