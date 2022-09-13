package com.hibernate.introduction.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.model.Persona;

public class PersonaService {
  // Atributos
  private SessionFactory factory;

  public PersonaService() {
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

  public List<Persona> obtenerPersonas() {
    List<Persona> personas = new ArrayList<>();
    Session session = crearSesion();
    try {
      personas = session.createQuery("from Persona", Persona.class).list();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return personas;
  }

  public Persona obtenerPersonaXId(int id) {
    Session session = crearSesion();
    Persona persona = new Persona();
    try {
      persona = session.find(Persona.class, id);
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return persona;
  }

  public List<Persona> obtenerPersonasXnombreApellido(String nombre, String apellido) {
    List<Persona> personas = new ArrayList<>();
    Session session = crearSesion();
    try {
      personas = session.createQuery("from Persona where nombre = :n and apellido = :a", Persona.class)
          .setParameter("n", nombre)
          .setParameter("a", apellido)
          .list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return personas;
  }

  public String crearPersona(Persona persona) {
    String message = "";
    Session session = crearSesion();
    try {
      session.persist(persona);
      session.getTransaction().commit();
      message = "Persona creada con éxito";
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }

    return message;
  }

  public String actualizarPersona(Persona persona) {
    String message = "";
    Session session = crearSesion();
    try {
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

  public String eliminarPersona(int id) {
    String message = "";
    Session session = crearSesion();
    try {
      session.remove(obtenerPersonaXId(id));
      session.getTransaction().commit();
      session.close();
      message = "Persona eliminada con éxito";
    } catch (Exception e) {
      message = e.getMessage();
    }
    return message;
  }

  public List<String> objToString(List<Persona> personas) {
    List<String> personasStr = new ArrayList<>();
    for (int i = 0; i < personas.size(); i++) {
      personasStr.add(personas.get(i).toString());
    }
    return personasStr;
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
