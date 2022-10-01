import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {
    protected static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Formateur> formateurs = new ArrayList<>();
    private static ArrayList<Apprenant> apprenants = new ArrayList<>();
    private static ArrayList<Promotion> promotions = new ArrayList<>();
    private static ArrayList<Apprenant> ApprenantInPromo = new ArrayList<>();
    private static ArrayList<Brief> briefs = new ArrayList<>();
    public static void CreateFormateur() {
        System.out.println("Entrer le prenom du formateur");
        String firstname = scanner.next();
        System.out.println("Entrer le nom du formateur");
        String lastname = scanner.next();
        System.out.println("Entrer l'email du formateur");
        String email = scanner.next();
        System.out.println("Entrer le password du formateur");
        String password = scanner.next();
        getFormateurs().add( new Formateur(firstname, lastname, email,password) );

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
            System.out.print(i + ". "+apprenants.get(i));
        }
    }
    public static void createPromotion(){
        System.out.println("Entrer le nom de la promotion");
        String promoName = scanner.next();
        System.out.println("Entrer le nom du formateur");
        String formateurName = scanner.next();

        DisplayApprenant();

        //if (numApprenants<=apprenants.size()){
        System.out.println("entrer la list des apprenants sous forme de (1-2-3-4-5)");
        String[] list = scanner.next().split("-");
        for (String s : list) {
            ApprenantInPromo.add(apprenants.get(Integer.parseInt(s)));
        }
        promotions.add(new Promotion(promoName, formateurName,ApprenantInPromo,briefs));

        //}else{
        //    System.out.println("S'il vous plait tapez un nombre correct");
        // }
        DisplayPromotion();
    }

    public static void DisplayPromotion(){

        for (Promotion promotion : promotions) {

            System.out.println(promotion);

        }
    }

    //

    public static ArrayList<Formateur> getFormateurs() {
        return formateurs;
    }

    public static void setFormateurs(ArrayList<Formateur> formateurs) {
        formateurs = formateurs;
    }

    public static ArrayList<Apprenant> getApprenants() {
        return apprenants;
    }

    public static void setApprenants(ArrayList<Apprenant> apprenants) {apprenants = apprenants;
    }

    public static ArrayList<Promotion> getPromotions() {
        return promotions;
    }

    public static void setPromotions(ArrayList<Promotion> promotions) {
        promotions = promotions;
    }

    public static ArrayList<Apprenant> getApprenantInPromo() {
        return ApprenantInPromo;
    }

    public static void setApprenantInPromo(ArrayList<Apprenant> apprenantInPromo)
    {
        ApprenantInPromo = apprenantInPromo;
    }
}
