import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {
    protected final Scanner scanner = new Scanner(System.in);
    private ArrayList<Formateur> formateurs = new ArrayList<>();
    private ArrayList<Apprenant> apprenants = new ArrayList<>();
    private   ArrayList<Promotion> promotions = new ArrayList<>();
    private   ArrayList<Apprenant> ApprenantInPromo = new ArrayList<>();
    public  void CreateFormateur() {
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

    public void DisplayFormateur(){

        for (Formateur formateur : formateurs) {
            formateur.display();
        }
    }
    public void CreateApprenant(){
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

    public void DisplayApprenant(){
        for(int i=0;i< apprenants.size();i++){
            System.out.print(i + ". "+apprenants.get(i));
        }
    }
    public void createPromotion(){
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
        promotions.add(new Promotion(promoName, formateurName,ApprenantInPromo));

        //}else{
        //    System.out.println("S'il vous plait tapez un nombre correct");
        // }
        DisplayPromotion();
    }

    public void DisplayPromotion(){

        for (Promotion promotion : promotions) {

            System.out.println(promotion);

        }
    }

    //

    public ArrayList<Formateur> getFormateurs() {
        return formateurs;
    }

    public void setFormateurs(ArrayList<Formateur> formateurs) {
        this.formateurs = formateurs;
    }

    public ArrayList<Apprenant> getApprenants() {
        return apprenants;
    }

    public void setApprenants(ArrayList<Apprenant> apprenants) {
        this.apprenants = apprenants;
    }

    public ArrayList<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(ArrayList<Promotion> promotions) {
        this.promotions = promotions;
    }

    public ArrayList<Apprenant> getApprenantInPromo() {
        return ApprenantInPromo;
    }

    public void setApprenantInPromo(ArrayList<Apprenant> apprenantInPromo)
    {
        ApprenantInPromo = apprenantInPromo;
    }
}
