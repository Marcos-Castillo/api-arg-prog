/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.web.marcoscastillo.apiArgProg.controller;

import app.web.marcoscastillo.apiArgProg.model.Persona;
import app.web.marcoscastillo.apiArgProg.service.IPersonaService;
import app.web.marcoscastillo.apiArgProg.util.Mensaje;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PersonaController {
    
        @Autowired
        public IPersonaService perServ;
        
        
    @GetMapping("/")
    @ResponseBody
    public String inicio() {
        return "API funcionando";
    }
        
    @GetMapping("/ver/persona")
    public ResponseEntity<List<Persona>> verPersonas() {
        log.info("get ver persona");
        List<Persona> personas = perServ.verPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }
    
        @GetMapping("/ver/persona/{id}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable("id") Long id) {
        Persona personas = perServ.buscarPersona(id);
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }
    
        @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/agregar/persona")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona pers) {
        perServ.crearPersona(pers);
        return new ResponseEntity(pers, HttpStatus.CREATED);
    }
    
        @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/persona")
    public ResponseEntity<Persona> editarPersona(@RequestBody Persona pers) {
        
        perServ.editarPersona(pers); 
       
        return new ResponseEntity(pers, HttpStatus.OK);
    }
        /*
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/persona/{id}")
    public ResponseEntity<Persona> borrarPersona(@PathVariable("id") Long id) {
        perServ.borrarPersona(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    */
    
}
