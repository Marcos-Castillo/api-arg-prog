package app.web.marcoscastillo.apiArgProg.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String profesion;
    private String ubicacion;
    private String about;
    private String urlImg;
    private String urlGithub;
    private String urlLinkedin;

    @JoinColumn(name = "id_persona")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Educacion> educacionList;

   
    @JoinColumn(name = "id_persona")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Experiencia> experienciaList;

    @JoinColumn(name = "id_persona")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Proyecto> proyectoList;

    @JoinColumn(name = "id_persona")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Skill> skillList;

}
