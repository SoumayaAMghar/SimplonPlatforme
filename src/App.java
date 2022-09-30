import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int role;

        System.out.println("Si vous etes admin tapez 0,Si vous etes formateur tapez 1");
        role = scanner.nextInt();

        if (role == 0) {
            while(true){
                System.out.println("------------------");
                System.out.println("1- ajouter formateur ");
                System.out.println("2- afficher formateur ");
                System.out.println("3- ajouter apprenant ");
                System.out.println("4- display student");
                System.out.println("5- Créer promotion");
                int choice = scanner.nextInt();
                seriveAdmin(choice);

            }

        } else if(role == 1){
            System.out.println("Entrer votre email");
            String email = scanner.next();
            System.out.println("Entrer votre password");
            String password = scanner.next();
            for(int i=0;i<Admin.formateurs.size();i++){

                Admin.formateurs.get(i).display();
            }

        }
    }


    public static void seriveAdmin(int choice) {

        switch (choice) {
            case 1 -> Admin.CreateFormateur();
            case 2 -> Admin.DisplayFormateur();
            case 3 -> Admin.CreateApprenant();
            case 4 -> Admin.DisplayApprenant();
            case 5 -> Admin.createPromotion();
        }

    }


}
