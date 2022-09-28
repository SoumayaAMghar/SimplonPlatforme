import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int role = 0;

        System.out.println("Si vous etes admin tapez 0,Si vous etes formateur tapez 1");
        role = scanner.nextInt();
        if (role == 0) {
            while(true){
                System.out.println("------------------");
                System.out.println("1- add student ");
                System.out.println("2- display student");
                int choice = scanner.nextInt();
                seriveAdmin(choice);

            }



        } else {

        }
    }


    public static void seriveAdmin(int choice) {

        switch (choice) {
            case 1:
                Admin.CreateApprenant();
                break;
            case 2:
                Admin.DisplayApprenant();
                break;

        }

    }


}
