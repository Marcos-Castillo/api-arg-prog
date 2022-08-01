
package app.web.marcoscastillo.apiArgProg.repository;

import app.web.marcoscastillo.apiArgProg.model.Experiencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends CrudRepository<Experiencia, Long>{
    
}
