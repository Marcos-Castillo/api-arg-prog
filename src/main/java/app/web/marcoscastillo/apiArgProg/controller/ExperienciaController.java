/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.web.marcoscastillo.apiArgProg.controller;

import app.web.marcoscastillo.apiArgProg.model.Experiencia;
import app.web.marcoscastillo.apiArgProg.service.IExperienciaService;
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
@CrossOrigin("https://marcos-castillo.web.app/")
public class ExperienciaController {
    
    @Autowired
    public IExperienciaService expServ;
    
    @GetMapping("/ver/experiencia")
    public ResponseEntity<List<Experiencia>> verExperiencia() {
        List<Experiencia> experiencias = expServ.verExperiencia();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }
    
    @GetMapping("/ver/experiencia/{id}")
    public ResponseEntity<Experiencia> buscarExperiencia(@PathVariable("id") Long id) {
        Experiencia experiencia = expServ.buscarExperiencia(id);
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/agregar/experiencia")
    public ResponseEntity<Experiencia> crearExperiencia(@RequestBody Experiencia exp) {
          if(exp.getPuesto() !="" || exp.getDescripcion() !=""|| exp.getIngreso() !=""|| exp.getEgreso() !="" ){
        return new ResponseEntity(new Mensaje("el campo no debe estar vacio"), HttpStatus.BAD_REQUEST);
        }
          
        expServ.crearExperiencia(exp);
        return new ResponseEntity(exp, HttpStatus.CREATED);
    }
    
        @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/experiencia")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia exp) {
          if(exp.getPuesto() !="" || exp.getDescripcion() !=""|| exp.getIngreso() !=""|| exp.getEgreso() !="" ){
        return new ResponseEntity(new Mensaje("el campo no debe estar vacio"), HttpStatus.BAD_REQUEST);
        }
        expServ.editarExperiencia(exp);
        return new ResponseEntity(exp, HttpStatus.OK);
    }
    
        @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/experiencia/{id}")
    public ResponseEntity<Experiencia> borrarExperiencia(@PathVariable("id") Long id) {
        expServ.borrarExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
