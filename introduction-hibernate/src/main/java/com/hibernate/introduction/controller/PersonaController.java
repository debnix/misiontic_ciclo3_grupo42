package com.hibernate.introduction.controller;

import java.util.ArrayList;
import java.util.Calendar;
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
  public boolean crearPersona(String nombre, String apellido, String email, Calendar fecha_naci, String foto) {
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

  public String obtenerPersonaXId(int id) {
    String personaStr = "";
    Session session = crearSesion();
    try {
      Persona persona = session.find(Persona.class, id);
      personaStr = persona.toString();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return personaStr;
  }

  public List<String> obtenerPersonas() {
    List<Persona> personas = new ArrayList<>();
    Session session = crearSesion();
    try {
      personas = session.createQuery("from Persona", Persona.class).list();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return objToString(personas);
  }

  public List<String> objToString(List<Persona> personas) {
    List<String> personasStr = new ArrayList<>();
    for (int i = 0; i < personas.size(); i++) {
      personasStr.add(personas.get(i).toString());
    }
    return personasStr;
  }

  public String actualizarPersona(int id, String nombre, String apellido, String email, Calendar fecha_naci,
      String foto) {
    String message = "";
    Session session = crearSesion();
    try {
      Persona persona = session.find(Persona.class, id);
      persona.setNombre(nombre);
      persona.setApellido(apellido);
      persona.setEmail(email);
      persona.setFecha_nacimiento(fecha_naci);
      persona.setFoto(foto);

      session.merge(persona);
      session.getTransaction().commit();
      session.close();
      message = "Persona actualizada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    return message;
  }

  public Calendar StringToCalendar(String fecha) {
    String[] dateString = fecha.split("/");
    int year = Integer.parseInt(dateString[2]);
    int month = Integer.parseInt(dateString[1]) - 1;
    int date = Integer.parseInt(dateString[0]);
    Calendar fechaCalendar = Calendar.getInstance();
    fechaCalendar.set(year, month, date);
    return fechaCalendar;
  }

}
