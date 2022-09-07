package com.hibernate.introduction;

import java.util.Date;
import java.util.List;

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
            /*********
             * CRUD
             **********/

            // Create

            // Crear objeto Persona
            /*
             * Persona objPersona = new Persona("Andrea", "Hernandez", "andrea@gmail.com",
             * new Date(),
             * "http://fake-photo");
             * // Preparar el objeto
             * session.persist(objPersona);
             */

            // Read
            // Persona persona = session.find(Persona.class, 2);
            // Persona persona = session.byId(Persona.class).load(1);
            // System.out.println(persona);
            List<Persona> personas = session.createQuery("from Persona", Persona.class).list();
            // Iterar lista
            for (int i = 0; i < personas.size(); i++) {
                System.out.println(personas.get(i));
            }

            // Guardar en la BD
            // session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cerrar sesión
        session.close();
    }
}
