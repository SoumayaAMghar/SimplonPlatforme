import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private static Scanner scanner = new Scanner(System.in);
    /* private static String apprenantNom;
     private static String apprenantPrenom;
     private static String apprenantEmail;
     private static String apprenatPassword;*/
    public static ArrayList<Apprenant> apprenants = new ArrayList<>();

    public Admin() {

    }


    public static void CreateApprenant() {

        System.out.println("Entrer le nom de l'apprenant");
        String firstname = scanner.next();
        System.out.println("Entrer le prenom de l'apprenant");
        String lastname = scanner.next();
        System.out.println("Entrer l'email de l'apprenant");
        String email = scanner.next();
        System.out.println("Entrer le password de l'apprenant");
        String password = scanner.next();
    Apprenant student= new Apprenant(firstname, lastname, email, password);
        apprenants.add(student);

    }


    public static void DisplayApprenant(){
        System.out.println(apprenants.size());
        for(int i=0;i< apprenants.size();i++){

            apprenants.get(i).display();


        }
    }

}

