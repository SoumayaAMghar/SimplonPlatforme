import service.AdminService;
import service.FormateurService;
//import service.FormateurService;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static AdminService adminService = new AdminService();
    private static FormateurService formateurService = new FormateurService();

    private static boolean formateur=false;
    private static boolean admin=false;
    private static boolean login=false;

    public static void main(String[] args) throws Exception {
        while(true){
            displayMainMenu();
        }
    }
    public static void displayMainMenu() throws Exception {
        System.out.println("Si vous etes admin tapez 0");
        System.out.println("Si vous etes formateur tapez 1");
        int role = scanner.nextInt();
        switch (role){
            case 0 -> {
                admin=true;
                login=false;
                while (admin) {
                    serviceAdmin();
                }
            }
            case 1 ->{
                formateur=true;
                while(formateur){
                    serviceFormateur();
                }

            }
        }

    }

    public static void serviceAdmin() throws Exception {

        System.out.println("1- ajouter formateur ");
        System.out.println("2- afficher formateur ");
        System.out.println("3- ajouter apprenant ");
        System.out.println("4- display student");
        System.out.println("5- Créer promotion");
        System.out.println("6- afficher promotion");
        System.out.println("0- Main menu");

        switch (scanner.nextInt()) {
            case 1 -> adminService.CreateFormateur();
            case 2 -> adminService.DisplayFormateur();
            case 3 -> adminService.CreateApprenant();
            case 4 -> adminService.DisplayApprenant();
            case 5 -> adminService.createPromotion();
            case 6 -> adminService.DisplayPromotion();
            case 0 ->{
                admin=false;
                formateur=false;
                displayMainMenu();
            }
        }

    }
    public static void serviceFormateur() throws Exception {

        if(!login){

          login = formateurService.login();
        }
        else{
            System.out.println("1- ajouter apprenants à la promotion ");
            System.out.println("2- créer un brief ");
            System.out.println("3- Distribuer brief(s) ");
            System.out.println("0- Main menu");

            switch (scanner.nextInt()) {
             /*   case 1 -> formateurService.AddApprenant();
                case 2 -> formateurService.AddBrief();
                case 3 -> formateurService.AssignBrief();*/
                case 0 ->{
                    admin=false;
                    formateur=false;
                    displayMainMenu();
                }
            }

        }


    }
}
