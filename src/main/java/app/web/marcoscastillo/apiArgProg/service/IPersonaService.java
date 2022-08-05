package app.web.marcoscastillo.apiArgProg.service;

import app.web.marcoscastillo.apiArgProg.model.Persona;
import java.util.List;



public interface IPersonaService {
    
    public List<Persona> verPersonas();
    
    public void crearPersona (Persona pers);
    
    public void borrarPersona (Long id);
    
    public Persona buscarPersona (Long id);
    
    public void editarPersona (Persona pers);  
    
}
