package logic.component.template.server.repository;

import logic.component.template.shared.model.Empresa;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@EntityScan
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
