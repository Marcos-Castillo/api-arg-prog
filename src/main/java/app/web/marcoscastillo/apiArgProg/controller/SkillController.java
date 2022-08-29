package app.web.marcoscastillo.apiArgProg.controller;

import app.web.marcoscastillo.apiArgProg.model.*;
import app.web.marcoscastillo.apiArgProg.service.*;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SkillController {


    @Autowired
    public ISkillService skillServ;

    // metodod get all
    @GetMapping("/")
    @ResponseBody
    public String inicio() {
        return "<a href=\"/ver/persona\">ver Personas</a> <br/>"
                + "<a href=\"/ver/educacion\">ver Educacion</a> <br/>"
                + "<a href=\"/ver/experiencia\">ver Experiencia</a> <br/>"
                + "<a href=\"/ver/proyecto\">ver Proyecto</a> <br/>"
                + "<a href=\"/ver/skill\">ver Skill</a> <br/>";
    }

    @GetMapping("/ver/skill")
    public ResponseEntity<List<Skill>> verSkill() {
        List<Skill> skill = skillServ.verSkill();
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

// metodod get by id

    @GetMapping("/ver/skill/{id}")
    public ResponseEntity<Skill> buscarSkill(@PathVariable("id") Long id) {
        Skill skill = skillServ.buscarSkill(id);
                if( skillServ.buscarSkill(id)==null)
            return new ResponseEntity(new Mensaje("Skill no encontrada"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    // metodod post  guardando

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/agregar/skill")
    public ResponseEntity<Skill> crearSkill(@RequestBody Skill skill) {
        if(skill.getCompetencia()<0 || skill.getCompetencia()>100){
        return new ResponseEntity(new Mensaje("el valor de competencia debe ser entr 0 y 100"), HttpStatus.BAD_REQUEST);
        }       
        if(skill.getNombre() !=""){
        return new ResponseEntity(new Mensaje("el campo no debe estar vacio"), HttpStatus.BAD_REQUEST);
        }
         skillServ.crearSkill(skill);
        return new ResponseEntity(skill, HttpStatus.CREATED);
    }

    // metodod put editando

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/skill")
    public ResponseEntity<Skill> editarSkill(@RequestBody Skill skill) {
        if(skill.getNombre() !=""){
        return new ResponseEntity(new Mensaje("el campo no debe estar vacio"), HttpStatus.BAD_REQUEST);
        }
                if(skill.getCompetencia()<0 || skill.getCompetencia()>100){
        return new ResponseEntity(new Mensaje("el valor de competencia debe ser entr 0 y 100"), HttpStatus.BAD_REQUEST);
        }    
        
        skillServ.editarSkill(skill);
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    // metodod delete borrando

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/skill/{id}")
    public ResponseEntity<Skill> borrarSkill(@PathVariable("id") Long id) {
        skillServ.borrarSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
