package com.hibernate.introduction;

import com.hibernate.introduction.controller.PersonaController;
import com.hibernate.introduction.view.PersonaView;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        PersonaController controller = new PersonaController();
        PersonaView view = new PersonaView(controller);
        view.buscarPersona();
    }
}
