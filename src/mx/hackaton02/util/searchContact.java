package mx.hackaton02.util;

import java.util.ArrayList;

public class searchContact {
    public String buscaContacto(ArrayList<String> list, String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Nombre de contacto a buscar: ";
        }

        String nameToSearch = name.trim().toLowerCase();

        for (String contact : list) {
            if (contact.toLowerCase().equals(nameToSearch)) {
                return "--- Contacto encontrado ---\n" +
                        "Información: " + contact + "\n";

            } // Cierre if
        } // Cierre for

        return "Contacto '" + name + "' no registrado en la agenda";
    }//cierre del método
}
