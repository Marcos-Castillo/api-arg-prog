package app.web.marcoscastillo.apiArgProg.service;

import app.web.marcoscastillo.apiArgProg.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    
    public List<Experiencia> verExperiencia();
    
    public void crearExperiencia (Experiencia exp);
    
    public void borrarExperiencia (Long id);
    
    public Experiencia buscarExperiencia (Long id);
    
    public void editarExperiencia (Long id);
    
}