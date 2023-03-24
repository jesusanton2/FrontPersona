
package com.portfolio.mgb.Controlador;

import com.portfolio.mgb.Entidad.Persona;
import com.portfolio.mgb.Interfaz.IPersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaControlador {
    @Autowired IPersonaServicio ipersonaServicio;
    
    @GetMapping("/persona/traer")
    public List<Persona> getPersona(){
        return ipersonaServicio.getPersona();
    }
    
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
       ipersonaServicio.savePersona(persona);
               return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long Id){
        ipersonaServicio.deletePersona(Id);
            return "La persona fue borrada correctamente";
        
    }
    
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long Id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg){
        Persona persona = ipersonaServicio.findPersona(Id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaServicio.savePersona(persona);
        return persona;
    }
    
}
