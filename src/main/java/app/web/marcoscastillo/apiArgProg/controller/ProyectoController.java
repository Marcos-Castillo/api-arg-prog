/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.web.marcoscastillo.apiArgProg.controller;

import app.web.marcoscastillo.apiArgProg.model.Proyecto;
import app.web.marcoscastillo.apiArgProg.service.IProyectoService;
import app.web.marcoscastillo.apiArgProg.util.Mensaje;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProyectoController {
    
        @Autowired
    public IProyectoService proyectoServ;
        
        
            @GetMapping("/ver/proyecto")
    public ResponseEntity<List<Proyecto>> verProyecto() {
        List<Proyecto> proyecto = proyectoServ.verProyecto();
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }
    
    @GetMapping("/ver/proyecto/{id}")
    public ResponseEntity<Proyecto> buscarProyecto(@PathVariable("id") Long id) {
        Proyecto proyecto = proyectoServ.buscarProyecto(id);
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }
        
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/agregar/proyecto")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
                if(proyecto.getTitulo() !="" || proyecto.getDescripcion() !=""|| proyecto.getLink() !=""|| proyecto.getUrlRepositorio() !="" ){
        return new ResponseEntity(new Mensaje("el campo no debe estar vacio"), HttpStatus.BAD_REQUEST);
        }
        proyectoServ.crearProyecto(proyecto);
        return new ResponseEntity(proyecto, HttpStatus.CREATED);
    }
    

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/proyecto")
    public ResponseEntity<Proyecto> editarProyecto(@RequestBody Proyecto proyecto) {
                if(proyecto.getTitulo() !="" || proyecto.getDescripcion() !=""|| proyecto.getLink() !=""|| proyecto.getUrlRepositorio() !="" ){
        return new ResponseEntity(new Mensaje("el campo no debe estar vacio"), HttpStatus.BAD_REQUEST);
        }
        proyectoServ.editarProyecto(proyecto);
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
        

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/proyecto/{id}")
    public ResponseEntity<Proyecto> borrarProyecto(@PathVariable("id") Long id) {
        proyectoServ.borrarProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
