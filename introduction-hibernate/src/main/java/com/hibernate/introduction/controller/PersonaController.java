package com.hibernate.introduction.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.model.Persona;

public class PersonaController {
  // Atributos
  private SessionFactory factory;

  // Constructor
  public PersonaController() {
    // Crear objeto que permita fabricar sesiones
    factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Persona.class)
        .buildSessionFactory();
  }

  private Session crearSesion() {
    Session session = factory.openSession();
    session.beginTransaction();
    return session;
  }

  /** ACCIONES */
  public boolean crearPersona(String nombre, String apellido, String email, Date fecha_naci, String foto) {
    boolean create = false;
    Session session = crearSesion();
    try {
      Persona persona = new Persona(nombre, apellido, email, fecha_naci, foto);
      session.persist(persona);
      session.getTransaction().commit();
      create = true;
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return create;
  }

  public List<Persona> obtenerPersonas() {
    List<Persona> personas = new ArrayList<>();
    Session session = crearSesion();
    try {
      personas = session.createQuery("from Persona", Persona.class).list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return personas;
  }
}
