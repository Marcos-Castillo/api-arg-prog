# Portafolio argentina programa API
  
  Portafolio realizado con [Angular CLI](https://github.com/angular/angular-cli) version 13.3.3. [Java Sprint Boot](https://spring.io/projects/spring-boot) y MySQL donde voy subiendo mis cursos y proyectos realizados 
  
  [URL proyecto ](https://marcos-castillo.web.app/#/home)
  
  
   
  
 Metodos admitidos
 ============ 
    
 - Método **GET** @GetMapping
 
 ("/") 
 
("/ver/persona") 

("/ver/educacion") 

 ("/ver/experiencia") 
 
 ("/ver/proyecto") 
 
 ("/ver/skill") 
 
 - Método **GET** by id @GetMapping
 
 ("/ver/persona/{id}") 
 
("/ver/educacion/{id}") 

 ("/ver/experiencia/{id}") 
 
 ("/ver/proyecto/{id}") 
 
 ("/ver/skill/{id}") 

-  Método **POST**  guardando _solo ADMIN_ @PostMapping

 
 ("/agregar/persona") 

 ("/agregar/educacion") 
 
 ("/agregar/experiencia") 
 
 ("/agregar/proyecto") 
 
 ("/agregar/skill") 
  
-  Método **PUT**  guardando _solo ADMIN_ @PutMapping
  
 ("/editar/persona") 
 
 ("/editar/educacion") 
 
 ("/editar/experiencia") 
 
 ("/editar/proyecto") 
 
 ("/editar/skill") 
  
-  Método **DELETE**  guardando _solo ADMIN_ @DeleteMapping
 
 ("/eliminar/persona/{id}") 
 
 ("/eliminar/educacion/{id}") 
 
 ("/eliminar/experiencia/{id}") 
 
 ("/eliminar/proyecto/{id}") 
 
("/eliminar/skill/{id}")
  
  
  
 ### Estructura 
  
  
 |  | descripcion | 
 -----------|-------------- 
 | [Front-end](https://github.com/Marcos-Castillo/portfolio-argentina-programa) | donde se encuentra la parte visual de la página web realizado en Angular | 
 | [Back-end](https://github.com/Marcos-Castillo/api-arg-prog) | donde se encuentra la API que relaciona la bbdd con el front-end | 
  
  
  
 Autor
 ======= 
  
 - Marcos Castillo 
     [https://github.com/Marcos-Castillo](https://github.com/Marcos-Castillo) 
 **ago. 2022**
