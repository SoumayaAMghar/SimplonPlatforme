import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person {
    private static final Scanner scanner = new Scanner(System.in);
    public static ArrayList<Formateur> formateurs = new ArrayList<>();
    public static ArrayList<Apprenant> apprenants = new ArrayList<>();
    public static ArrayList<Promotion> promotions = new ArrayList<>();
    public static ArrayList<Apprenant> ApprenantInPromo = new ArrayList<>();

    public Admin() {

    }

    public static void CreateFormateur() {
        System.out.println("Entrer le prenom du formateur");
        String firstname = scanner.next();
        System.out.println("Entrer le nom du formateur");
        String lastname = scanner.next();
        System.out.println("Entrer l'email du formateur");
        String email = scanner.next();
        System.out.println("Entrer le password du formateur");
        String password = scanner.next();
        formateurs.add( new Formateur(firstname, lastname, email,password) );
    }

    public static void DisplayFormateur(){

        for (Formateur formateur : formateurs) {
            formateur.display();
        }
    }
    public static void CreateApprenant(){
        System.out.println("Entrer le prenom de l'apprenant");
        String firstname = scanner.next();
        System.out.println("Entrer le nom de l'apprenant");
        String lastname = scanner.next();
        System.out.println("Entrer l'email de l'apprenant");
        String email = scanner.next();
        System.out.println("Entrer le password de l'apprenant");
        String password = scanner.next();
        apprenants.add( new Apprenant(firstname, lastname, email,password) );
    }

    public static void DisplayApprenant(){
        for(int i=0;i< apprenants.size();i++){
            System.out.print(i + ". ");
            apprenants.get(i).display();
        }
    }
    public static void createPromotion(){
        System.out.println("Entrer le nom de la promotion");
        String promoName = scanner.next();
        System.out.println("Entrer le nom du formateur");
        String formateur = scanner.next();
        //System.out.println("taper le nombre des apprenants que vous voulez attribuer à la promotion");
        //int numApprenants = scanner.nextInt();
        DisplayApprenant();

        //if (numApprenants<=apprenants.size()){
            System.out.println("entrer la list des apprenants sous forme de (1-2-3-4-5)");
            String[] list = scanner.next().split("-");
        for (String s : list) {
            ApprenantInPromo.add(apprenants.get(Integer.parseInt(s)));
        }
            promotions.add(new Promotion(promoName, formateur,ApprenantInPromo));

        //}else{
        //    System.out.println("S'il vous plait tapez un nombre correct");
       // }
        DisplayPromotion();
    }

    public static void DisplayPromotion(){

        for (Promotion promotion : promotions) {

            promotion.display();

        }
    }

}

