package app.web.marcoscastillo.apiArgProg.controller;

/*
import app.web.marcoscastillo.apiArgProg.security.JwtDto;
import app.web.marcoscastillo.apiArgProg.security.LoginUser;
import app.web.marcoscastillo.apiArgProg.security.JwtProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/

import org.springframework.security.authentication.AuthenticationManager;
import app.web.marcoscastillo.apiArgProg.model.*;
import app.web.marcoscastillo.apiArgProg.service.*;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class Contoller {

    //
    /*
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    AuthenticationManager authenticationManager;*/
    //

    @Autowired
    public IEducacionService eduServ;
    @Autowired
    public IExperienciaService expServ;
    @Autowired
    public IPersonaService perServ;
    @Autowired
    public IProyectoService proyectoServ;
    @Autowired
    public ISkillService skillServ;

    //Autorizacion
    /*
    @PostMapping("/auth")
    public ResponseEntity<JwtDto> login(@RequestBody LoginUser loginUser) {
        //validar usuario y devolver un jwt<--
         log.info("###########################");
               log.info(loginUser.toString());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }*/

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

    @GetMapping("/ver/persona")
    public ResponseEntity<List<Persona>> verPersonas() {
        log.info("get ver persona");
        List<Persona> personas = perServ.verPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/ver/educacion")
    public ResponseEntity<List<Educacion>> verEducacion() {
        List<Educacion> educaciones = eduServ.verEducacion();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }

    @GetMapping("/ver/experiencia")
    public ResponseEntity<List<Experiencia>> verExperiencia() {
        List<Experiencia> experiencias = expServ.verExperiencia();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }

    @GetMapping("/ver/proyecto")
    public ResponseEntity<List<Proyecto>> verProyecto() {
        List<Proyecto> proyecto = proyectoServ.verProyecto();
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }

    @GetMapping("/ver/skill")
    public ResponseEntity<List<Skill>> verSkill() {
        List<Skill> skill = skillServ.verSkill();
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

// metodod get by id
    @GetMapping("/ver/persona/{id}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable("id") Long id) {
        Persona personas = perServ.buscarPersona(id);
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/ver/educacion/{id}")
    public ResponseEntity<Educacion> buscarEducacion(@PathVariable("id") Long id) {
        Educacion educacion = eduServ.buscarEducacion(id);
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }

    @GetMapping("/ver/experiencia/{id}")
    public ResponseEntity<Experiencia> buscarExperiencia(@PathVariable("id") Long id) {
        Experiencia experiencia = expServ.buscarExperiencia(id);
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }

    @GetMapping("/ver/proyecto/{id}")
    public ResponseEntity<Proyecto> buscarProyecto(@PathVariable("id") Long id) {
        Proyecto proyecto = proyectoServ.buscarProyecto(id);
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }

    @GetMapping("/ver/skill/{id}")
    public ResponseEntity<Skill> buscarSkill(@PathVariable("id") Long id) {
        Skill skill = skillServ.buscarSkill(id);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    // metodod post  guardando
    @PostMapping("/agregar/persona")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona pers) {
        perServ.crearPersona(pers);
        return new ResponseEntity(pers, HttpStatus.CREATED);//httpstatus 201  ok + modificado
    }

    @PostMapping("/agregar/educacion")
    public ResponseEntity<Educacion> crearEducacion(@RequestBody Educacion edu) {
        eduServ.crearEducacion(edu);
        return new ResponseEntity(edu, HttpStatus.CREATED);
    }

    @PostMapping("/agregar/experiencia")
    public ResponseEntity<Experiencia> crearExperiencia(@RequestBody Experiencia exp) {
        expServ.crearExperiencia(exp);
        return new ResponseEntity(exp, HttpStatus.CREATED);
    }

    @PostMapping("/agregar/proyecto")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
        proyectoServ.crearProyecto(proyecto);
        return new ResponseEntity(proyecto, HttpStatus.CREATED);
    }

    @PostMapping("/agregar/skill")
    public ResponseEntity<Skill> crearSkill(@RequestBody Skill skill) {
        skillServ.crearSkill(skill);
        return new ResponseEntity(skill, HttpStatus.CREATED);
    }

    // metodod put editando
    @PutMapping("/editar/persona")
    public ResponseEntity<Persona> editarPersona(@RequestBody Persona pers) {
        perServ.editarPersona(pers);
        return new ResponseEntity(pers, HttpStatus.OK);
    }

    @PutMapping("/editar/educacion")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion edu) {
        eduServ.editarEducacion(edu);
        return new ResponseEntity(edu, HttpStatus.OK);
    }

    @PutMapping("/editar/experiencia")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia exp) {
        expServ.editarExperiencia(exp);
        return new ResponseEntity(exp, HttpStatus.OK);
    }

    @PutMapping("/editar/proyecto")
    public ResponseEntity<Proyecto> editarProyecto(@RequestBody Proyecto proyecto) {
        proyectoServ.editarProyecto(proyecto);
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PutMapping("/editar/skill")
    public ResponseEntity<Skill> editarSkill(@RequestBody Skill skill) {
        skillServ.editarSkill(skill);
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    // metodod delete borrando
    @DeleteMapping("/eliminar/persona/{id}")
    public ResponseEntity<Persona> borrarPersona(@PathVariable("id") Long id) {
        perServ.borrarPersona(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/educacion/{id}")
    public ResponseEntity<Educacion> borrarEducacion(@PathVariable("id") Long id) {
        eduServ.borrarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/experiencia/{id}")
    public ResponseEntity<Experiencia> borrarExperiencia(@PathVariable("id") Long id) {
        expServ.borrarExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/proyecto/{id}")
    public ResponseEntity<Proyecto> borrarProyecto(@PathVariable("id") Long id) {
        proyectoServ.borrarProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/skill/{id}")
    public ResponseEntity<Skill> borrarSkill(@PathVariable("id") Long id) {
        skillServ.borrarSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
