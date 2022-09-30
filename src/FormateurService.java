import java.util.ArrayList;
import java.util.Scanner;

public class FormateurService {

    protected final Scanner scanner = new Scanner(System.in);
    private AdminService adminService = new AdminService();

    public void AddApprenant(){
        System.out.println("Entrer votre email");
        String email = scanner.next();
        System.out.println("Entrer votre password");
        String password = scanner.next();
        //Now after he enters the email and password we should find them in Fromateur arraylist in adminservice
        for(int i=0;i<adminService.getFormateurs().size();i++){
            //we should check the email and password in Formateur arraylist
            if (email.equals(adminService.getFormateurs().get(i).getEmail())&& password.equals(adminService.getFormateurs().get(i).getPassword())){
                //Now we should look for the formateur in the Promotion arraylist in adminservice to know wich is the formateur's promo where he can add the students
                for(int j=0;j<adminService.getPromotions().size();j++){
                    //we check if the formateur in the Promotion arraylist is the same in the Formateur Arraylist
                 if (adminService.getPromotions().get(j).getFormateurName().equals(adminService.getFormateurs().get(i).getLastname())){
                     System.out.println("entrer la list des apprenants sous forme de (1-2-3-4-5)");
                     String[] list = scanner.next().split("-");

                     for (String s : list) {
                         adminService.getPromotions().get(j).getStudents().add( adminService.getApprenants().get(Integer.parseInt(s)));
                     }

                 }
                }



                    adminService.DisplayPromotion();

            }
        }

    }
}
