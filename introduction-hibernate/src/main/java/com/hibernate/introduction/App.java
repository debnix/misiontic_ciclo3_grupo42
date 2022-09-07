package com.hibernate.introduction;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.model.Persona;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Crear objeto que permita fabricar sesiones
        SessionFactory factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Persona.class)
                .buildSessionFactory();

        // Abrir sesión
        Session session = factory.openSession();

        // Preparar la sesión para realizar transacciones
        session.beginTransaction();
        // Realizar transacciones...
        try {
            // Crear objeto Persona
            Persona objPersona = new Persona("Sara", "Camacho", "sara@gmail.com", new Date(), "http://fake-photo");
            // Preparar el objeto
            session.persist(objPersona);
            // Guardar en la BD
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cerrar sesión
        session.close();
    }
}
