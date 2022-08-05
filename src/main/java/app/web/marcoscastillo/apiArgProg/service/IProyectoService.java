package app.web.marcoscastillo.apiArgProg.service;

import app.web.marcoscastillo.apiArgProg.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    
    public List<Proyecto> verProyecto();
    
    public void crearProyecto (Proyecto proyecto);
    
    public void borrarProyecto (Long id);
    
    public Proyecto buscarProyecto (Long id);
    
    public void editarProyecto (Proyecto proyecto);
    
}