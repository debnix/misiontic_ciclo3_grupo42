package com.hibernate.introduction.controller;

import java.util.Date;

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

  /** ACCIONES */
  public boolean crearPersona(String nombre, String apellido, String email, Date fecha_naci, String foto) {
    boolean create = false;
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      Persona persona = new Persona(nombre, apellido, email, fecha_naci, foto);
      session.persist(persona);
      session.getTransaction().commit();
      create = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return create;
  }
}
