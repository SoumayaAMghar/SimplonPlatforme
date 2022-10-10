package service;
import dao.admin;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminService {

     private admin admin;
    public static Scanner scanner=new Scanner(System.in);

  public AdminService(){
       admin = new admin();
  }


    public void CreateFormateur() throws Exception {


        System.out.println("Entrer le prenom du formateur");
        String firstname = scanner.next();
        System.out.println("Entrer le nom du formateur");
        String lastname = scanner.next();
        System.out.println("Entrer l'email du formateur");
        String email = scanner.next();
        System.out.println("Entrer le password du formateur");
        String password = scanner.next();

        admin.addFormateur(firstname,lastname,email,password);

    }
    public void DisplayFormateur(){
        admin.DisplayFormateur();
    }


    public  void CreateApprenant() throws Exception{
        System.out.println("Entrer le prenom de l'apprenant");
        String firstname = scanner.next();
        System.out.println("Entrer le nom de l'apprenant");
        String lastname = scanner.next();
        System.out.println("Entrer l'email de l'apprenant");
        String email = scanner.next();
        System.out.println("Entrer le password de l'apprenant");
        String password = scanner.next();
        admin.addApprenant(firstname,lastname,email,password);

    }
    public void DisplayApprenant(){
        admin.DisplayApprenant();
    }


    public  void createPromotion() throws SQLException {
        System.out.println("Entrer le nom de la promotion");
        String promoName = scanner.next();
        admin.DisplayFormateurWithoutPromo();
        System.out.println("Veuillez choisir l'id du formateur que vous voulez");
        int formateurId = scanner.nextInt();
        admin.ApprenantsWithoutPromotion();
        System.out.println("entrer la list des apprenants sous forme de (1-2-3-4-5)");
        String[] listApprenant = scanner.next().split("-");

        admin.createPromotion(promoName, formateurId, listApprenant);
    }

    public void DisplayPromotion(){
        admin.DisplayPromotion();
    }

    //


}
