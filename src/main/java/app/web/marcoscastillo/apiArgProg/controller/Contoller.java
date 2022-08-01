package app.web.marcoscastillo.apiArgProg.controller;

import app.web.marcoscastillo.apiArgProg.model.Persona;
import app.web.marcoscastillo.apiArgProg.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contoller {

    @Autowired
    public IPersonaService perServ;

    @GetMapping("/")
    @ResponseBody
    public List<Persona> inicio() {

        return perServ.verPersonas();
    }
}
