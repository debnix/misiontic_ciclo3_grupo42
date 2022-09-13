package com.hibernate.introduction.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hibernate.introduction.model.Persona;
import com.hibernate.introduction.services.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

  // Atributos
  PersonaService service;

  // Constructor
  public PersonaController() {
    service = new PersonaService();
  }

  /** ACCIONES */
  @CrossOrigin(origins = "http://localhost:5500")
  @GetMapping
  public List<Persona> obtenerPersonas() {
    return service.obtenerPersonas();
  }

  @GetMapping("/{id}")
  public Persona obtenerPersonaXId(@PathVariable(name = "id") int id) {
    return service.obtenerPersonaXId(id);
  }

  @GetMapping("/commons")
  public List<Persona> obtenerPersonasXnombreApellido(@RequestParam String nombre, @RequestParam String apellido) {
    return service.obtenerPersonasXnombreApellido(nombre, apellido);
  }

  @PostMapping
  public String crearPersona(@RequestBody Persona persona) {
    return service.crearPersona(persona);
  }

  @PutMapping
  public String actualizarPersona(@RequestBody Persona persona) {
    return service.actualizarPersona(persona);
  }

  @DeleteMapping("/{id}")
  public String eliminarPersona(@PathVariable(name = "id") int id) {
    return service.eliminarPersona(id);
  }
}
