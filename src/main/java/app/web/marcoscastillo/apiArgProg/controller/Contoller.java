package app.web.marcoscastillo.apiArgProg.controller;

import app.web.marcoscastillo.apiArgProg.model.*;
import app.web.marcoscastillo.apiArgProg.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contoller {

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
    @ResponseBody
    public List<Persona> verPersonas() {

        return perServ.verPersonas();
    }

    @GetMapping("/ver/educacion")
    @ResponseBody
    public List<Educacion> verEducacion() {

        return eduServ.verEducacion();
    }

    @GetMapping("/ver/experiencia")
    @ResponseBody
    public List<Experiencia> verExperiencia() {

        return expServ.verExperiencia();
    }

    @GetMapping("/ver/proyecto")
    @ResponseBody
    public List<Proyecto> verProyecto() {

        return proyectoServ.verProyecto();
    }

    @GetMapping("/ver/skill")
    @ResponseBody
    public List<Skill> verSkill() {

        return skillServ.verSkill();
    }
}
