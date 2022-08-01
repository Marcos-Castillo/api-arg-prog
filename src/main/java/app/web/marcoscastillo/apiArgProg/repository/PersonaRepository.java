
package app.web.marcoscastillo.apiArgProg.repository;

import app.web.marcoscastillo.apiArgProg.model.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    
}
