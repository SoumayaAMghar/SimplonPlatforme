import java.util.ArrayList;
import java.util.Scanner;

public class FormateurService {

    protected static Scanner scanner = new Scanner(System.in);

    private ArrayList<Brief> briefs  = new ArrayList<>();
    private static int indiceFormateur;

    public static boolean login(){
        boolean flag=false;
        ArrayList<Apprenant> students = new ArrayList<>();
        students.add(new Apprenant("firstname","lastname","email.com","password"));
        students.add(new Apprenant("firstname1","lastname1","email1.com","password1"));
        students.add(new Apprenant("firstname2","lastname2","email2.com","password2"));
        AdminService.getPromotions().add(new Promotion("alan turing","formateur1",students));
        AdminService.getApprenants().add(new Apprenant("firstname2","lastname2","email2.com","password2"));
        AdminService.getApprenants().add(new Apprenant("firstname1","lastname1","email1.com","password1"));
        AdminService.getApprenants().add(new Apprenant("firstname","lastname","email.com","password"));
        ArrayList<Formateur> formateurs = new ArrayList<>();
        AdminService.getFormateurs().add(new Formateur("formateur1","formateur1","formateur1.com", "formateur1"));
        AdminService.getFormateurs().add(new Formateur("formateur2","formateur2","formateur2.com", "formateur2"));
        AdminService.getFormateurs().add(new Formateur("formateur3","formateur3","formateur3.com", "formateur3"));

        System.out.println("Entrer votre email");
        String email = scanner.next();
        System.out.println("Entrer votre password");
        String password = scanner.next();
        //System.out.println(AdminService.getFormateurs().size());
        for(int i=0;i< AdminService.getFormateurs().size(); i++){
            if (email.equals(AdminService.getFormateurs().get(i).getEmail()) && password.equals(AdminService.getFormateurs().get(i).getPassword())){
                System.out.println("welcome");
                    flag=true;
                    indiceFormateur = i;
            }
        }
        return flag;
    }

    public void AddApprenant(){

        for(int i=0;i<AdminService.getPromotions().size();i++){
         if (AdminService.getPromotions().get(i).getFormateurName().equals(AdminService.getFormateurs().get(i).getLastname())){
             System.out.println("entrer la list des apprenants sous forme de (1-2-3-4-5)");
             String[] list = scanner.next().split("-");
             for (String s : list) {
                 System.out.println(s);
                 AdminService.getPromotions().get(i).getStudents().add( AdminService.getApprenants().get(Integer.parseInt(s)));
             }
             AdminService.DisplayPromotion();
         }else{
             System.out.println("Ce formateur n'est pas créer");
         }
        }
        }

    public void AddBrief(){
        String briefTitle;
        String briefContext;
        System.out.println("Entrer le titre du brief");
        briefTitle = scanner.next();
        System.out.println("Enter la description du brief");
        briefContext = scanner.next();
        briefs.add(new Brief(briefTitle,briefContext,AdminService.getFormateurs().get(indiceFormateur)));
        System.out.println(briefs);
    }
    public void AssignBrief(){
        Promotion promotion = new Promotion();
        System.out.println("Voici la liste des briefs");
        //System.out.println(briefs);
        for (int i = 0 ; i <briefs.size() ; i++){
           if(AdminService.getFormateurs().get(indiceFormateur).equals(briefs.get(i).getFormateur())){
               System.out.println(briefs.get(i));
           }
        }
        System.out.println("Entrer l'indice du brief(s) à distribuer sous forme de(0-1-2-3)");
        String[] listBriefs = scanner.next().split("-");
        for (int i=0; i<listBriefs.length; i++){
            System.out.println(briefs.get(Integer.parseInt(listBriefs[i])));

        }
    }
}
