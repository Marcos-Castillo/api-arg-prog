/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.web.marcoscastillo.apiArgProg.controller;

import app.web.marcoscastillo.apiArgProg.model.Educacion;
import app.web.marcoscastillo.apiArgProg.service.IEducacionService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nout
 */
@RestController
@Slf4j
public class EducacionController {
    
    
    @Autowired
    public IEducacionService eduServ;
    
    
    
    @GetMapping("/ver/educacion")
    public ResponseEntity<List<Educacion>> verEducacion() {
        List<Educacion> educaciones = eduServ.verEducacion();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }
    
    
    @GetMapping("/ver/educacion/{id}")
    public ResponseEntity<Educacion> buscarEducacion(@PathVariable("id") Long id) {
        Educacion educacion = eduServ.buscarEducacion(id);
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/agregar/educacion")
    public ResponseEntity<Educacion> crearEducacion(@RequestBody Educacion edu) {
        
          if(edu.getTitulo().isBlank() || edu.getExpedicion().isBlank()|| edu.getDescripcion().isBlank()|| edu.getCredencial().isBlank() ){
        return new ResponseEntity(edu, HttpStatus.BAD_REQUEST);
        }
        eduServ.crearEducacion(edu);
        return new ResponseEntity(edu, HttpStatus.CREATED);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/educacion")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion edu) {
          
          if(edu.getTitulo().isBlank() || edu.getExpedicion().isBlank()|| edu.getDescripcion().isBlank()|| edu.getCredencial().isBlank() ){
        return new ResponseEntity(edu, HttpStatus.BAD_REQUEST);
        }
        eduServ.editarEducacion(edu);
        return new ResponseEntity(edu, HttpStatus.OK);
    }
    
        @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/educacion/{id}")
    public ResponseEntity<Educacion> borrarEducacion(@PathVariable("id") Long id) {
        eduServ.borrarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
