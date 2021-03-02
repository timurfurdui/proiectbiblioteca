package com.timur.databasebiblioteca.security;

import com.timur.databasebiblioteca.gui.FXMLPaginaInregistrareController;

import java.util.HashMap;
import java.util.Map;

public class Authenticator extends FXMLPaginaInregistrareController {

    private static final Map<String, String> USERS = new HashMap<String, String>();

    private String user = getUtilizator();
    private String parola = getParola();
    private String confParola = getConfirmParola();

    static {
        USERS.put("demo", "demo");
    }

    public static boolean validate(String user, String password) {
        String validUserPassword = USERS.get(user);
        return validUserPassword != null && validUserPassword.equals(password);
    }
}
