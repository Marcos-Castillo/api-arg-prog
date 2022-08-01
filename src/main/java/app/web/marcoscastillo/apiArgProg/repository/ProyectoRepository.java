
package app.web.marcoscastillo.apiArgProg.repository;

import app.web.marcoscastillo.apiArgProg.model.Proyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends CrudRepository<Proyecto, Long>{
    
}
