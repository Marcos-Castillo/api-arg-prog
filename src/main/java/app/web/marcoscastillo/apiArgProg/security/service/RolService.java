package app.web.marcoscastillo.apiArgProg.security.service;

import app.web.marcoscastillo.apiArgProg.security.entity.Rol;
import app.web.marcoscastillo.apiArgProg.security.enums.RolNombre;
import app.web.marcoscastillo.apiArgProg.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return  rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
