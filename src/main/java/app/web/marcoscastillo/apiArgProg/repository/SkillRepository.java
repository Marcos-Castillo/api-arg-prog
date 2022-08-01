
package app.web.marcoscastillo.apiArgProg.repository;

import app.web.marcoscastillo.apiArgProg.model.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository  extends CrudRepository<Skill, Long>{
    
}
