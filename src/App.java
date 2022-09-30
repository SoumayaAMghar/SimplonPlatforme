import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static AdminService adminService =new AdminService();

    public static void main(String[] args) {
        int role;

        System.out.println("Si vous etes admin tapez 0,Si vous etes formateur tapez 1");
        role = scanner.nextInt();
        Person p = new Person();
        System.out.println(p);

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


        }
    }


    public static void seriveAdmin(int choice) {
        switch (choice) {
            case 1 -> adminService.CreateFormateur();
            case 2 -> adminService.DisplayFormateur();
            case 3 -> adminService.CreateApprenant();
            case 4 -> adminService.DisplayApprenant();
            case 5 -> adminService.createPromotion();
        }

    }


}
