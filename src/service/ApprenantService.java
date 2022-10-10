package service;

import dao.Cookie;
import dao.apprenant;
import login.Login;

import java.sql.SQLException;
import java.util.Scanner;

public class ApprenantService {
    public static Scanner scanner = new Scanner(System.in);
    public Cookie cookie = new Cookie();
    public apprenant apprenant = new apprenant();
    public boolean login() throws SQLException {
        System.out.println("entrer votre email");
        String email = scanner.next();
        System.out.println("entrer votre password");
        String password = scanner.next();

        return Login.login(email, password,"apprenant");
    }

    public void displayBriefs() throws SQLException {
        System.out.println("-----------brief available------------");
        apprenant.Displaybriefs(cookie.getIdPromtion());
    }
}



