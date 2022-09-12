package com.hibernate.introduction.view;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.hibernate.introduction.controller.PersonaController;

public class PersonaView {

  private PersonaController controller;

  public PersonaView(PersonaController controller) {
    this.controller = controller;
  }

  public void crearPersona() {
    // Solicitar datos
    String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre");
    String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido");
    String email = JOptionPane.showInputDialog(null, "Ingrese el Email");
    String fecha = JOptionPane.showInputDialog(null, "Fecha nacimiento (dd/mm/aaaa): ");
    String foto = JOptionPane.showInputDialog(null, "Url foto: ");

    String[] dateString = fecha.split("/");
    int year = Integer.parseInt(dateString[2]);
    int month = Integer.parseInt(dateString[1]);
    int date = Integer.parseInt(dateString[0]);
    Date fecha_nacimiento = new Date(year, month, date);
    // Crear persona
    boolean create = controller.crearPersona(nombre, apellido, email, fecha_nacimiento, foto);
    if (create) {
      JOptionPane.showMessageDialog(null, "Persona creada con éxito");
    } else {
      JOptionPane.showMessageDialog(null, "Por favor intenta mas tarde");
    }
  }

  public void mostrarPersonas() {
    List<String> personas = controller.obtenerPersonas();
    String info = "--------------PERSONAS-------------\n";
    for (int i = 0; i < personas.size(); i++) {
      info += personas.get(i);
    }
    JOptionPane.showMessageDialog(null, info);
  }

  public void buscarPersona() {

  }

  public void eliminarPersona() {

  }

  public void actualizarPersona() {

  }

}
