
package app.web.marcoscastillo.apiArgProg.repository;

import app.web.marcoscastillo.apiArgProg.model.Educacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends CrudRepository<Educacion, Long>{
    
}
