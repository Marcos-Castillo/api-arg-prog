package app.web.marcoscastillo.apiArgProg.security.repository;

import app.web.marcoscastillo.apiArgProg.security.entity.Rol;
import app.web.marcoscastillo.apiArgProg.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
