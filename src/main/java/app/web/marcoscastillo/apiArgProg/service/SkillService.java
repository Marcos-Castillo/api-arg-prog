
package app.web.marcoscastillo.apiArgProg.service;

import app.web.marcoscastillo.apiArgProg.model.Skill;
import app.web.marcoscastillo.apiArgProg.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService  implements ISkillService{
    
    @Autowired
    public SkillRepository skillRepo;

    @Override
    public List<Skill> verSkill() {
        return (List<Skill>) skillRepo.findAll();
    }

    @Override
    public void crearSkill (Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public void borrarSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Long id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public void editarSkill(Long id) {
      //implementacion pendiente
    }
    
}
