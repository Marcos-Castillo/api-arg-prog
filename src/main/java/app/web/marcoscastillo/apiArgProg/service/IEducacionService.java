package app.web.marcoscastillo.apiArgProg.service;

import app.web.marcoscastillo.apiArgProg.model.Educacion;
import java.util.List;

public interface IEducacionService {
    
    public List<Educacion> verEducacion();
    
    public void crearEducacion (Educacion edu);
    
    public void borrarEducacion (Long id);
    
    public Educacion buscarEducacion (Long id);
    
    public void editarEducacion (Long id);
    
}