package com.hibernate.introduction.model;

public class Persona {

  // ATRIBUTOS
  private int id;
  private String nombre;
  private String apellido;
  private String email;
  private String fecha_nacimiento;
  private String foto;

  // CONSTRUCTORES

  public Persona() {
  }

  public Persona(String nombre, String apellido, String email, String fecha_nacimiento, String foto) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.fecha_nacimiento = fecha_nacimiento;
    this.foto = foto;
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

  public String getFecha_nacimiento() {
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

  public void setFecha_nacimiento(String fecha_nacimiento) {
    this.fecha_nacimiento = fecha_nacimiento;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

}
