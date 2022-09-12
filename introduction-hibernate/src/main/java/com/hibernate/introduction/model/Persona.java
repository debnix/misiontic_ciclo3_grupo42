package com.hibernate.introduction.model;

import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indicar que la clase Persona representa una entidad de la BD
@Entity
// Indicar la entidad/tabla que representa la clase Persona
@Table(name = "users")
public class Persona {

  // ATRIBUTOS
  @Id
  private int id;
  private String nombre;
  private String apellido;
  private String email;
  // @Column(name = "fecha_nacimiento")
  private Calendar fecha_nacimiento;
  private String foto;

  // CONSTRUCTORES

  public Persona() {
  }

  public Persona(String nombre, String apellido, String email, Calendar fecha_nacimiento, String foto) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.fecha_nacimiento = fecha_nacimiento;
    this.foto = foto;
  }

  @Override
  public String toString() {
    String info = "-------------------------------\n";
    info += "Id: " + id;
    info += "\nNombre: " + nombre;
    info += "\nApellido: " + apellido;
    info += "\nEmail: " + email;
    info += "\nFecha nacimiento: " + fecha_nacimiento;
    info += "\nFoto: " + foto;
    info += "\n-------------------------------\n";
    return info;
  }

  // CONSULTORES // GETTERS
  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getEmail() {
    return email;
  }

  public Calendar getFecha_nacimiento() {
    return fecha_nacimiento;
  }

  public String getFoto() {
    return foto;
  }

  // MODIFICADORES
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setFecha_nacimiento(Calendar fecha_nacimiento) {
    this.fecha_nacimiento = fecha_nacimiento;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

}
