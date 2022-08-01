package app.web.marcoscastillo.apiArgProg.service;

import app.web.marcoscastillo.apiArgProg.model.Skill;
import java.util.List;

public interface ISkillService {
    
    public List<Skill> verSkill();
    
    public void crearSkill (Skill skill);
    
    public void borrarSkill (Long id);
    
    public Skill buscarSkill (Long id);
    
    public void editarSkill (Long id);
    
}