import java.util.ArrayList;
import java.util.Scanner;

public class FormateurService {

    protected static Scanner scanner = new Scanner(System.in);

    private ArrayList<Brief> briefs = new ArrayList<>();
    private static int indiceFormateur;

    public static boolean login() {
        boolean flag = false;
        ArrayList<Apprenant> students = new ArrayList<>();
        ArrayList<Brief> briefs = new ArrayList<>();
        students.add(new Apprenant(true,"soumaya", "amghar", "amghar.souma@gmail.com", "password"));
        students.add(new Apprenant(true,"abdelghafour", "ettaqui", "ettaqui88@gmail.com", "password1"));
        students.add(new Apprenant(true, "abdelghafour", "abdelghafour", "ettaqui88@gmail.com", "password2"));

        AdminService.getPromotions().add(new Promotion("alan turing", "formateur1", students, briefs));

        AdminService.getApprenants().add(new Apprenant(true,"firstname2", "lastname2", "ettaqui88@gmail.com", "password2"));
        AdminService.getApprenants().add(new Apprenant(true,"firstname1", "lastname1", "ettaqui88@gmail.com", "password1"));
        AdminService.getApprenants().add(new Apprenant(true,"firstname", "lastname", "ettaqui88@gmail.com", "password"));
        ArrayList<Formateur> formateurs = new ArrayList<>();
        AdminService.getFormateurs().add(new Formateur("formateur1", "formateur1", "formateur1.com", "formateur1"));
        AdminService.getFormateurs().add(new Formateur("formateur2", "formateur2", "formateur2.com", "formateur2"));
        AdminService.getFormateurs().add(new Formateur("formateur3", "formateur3", "formateur3.com", "formateur3"));


        System.out.println("Entrer votre email");
        String email = scanner.next();
        System.out.println("Entrer votre password");
        String password = scanner.next();
        //System.out.println(AdminService.getFormateurs().size());
        for (int i = 0; i < AdminService.getFormateurs().size(); i++) {
            if (email.equals(AdminService.getFormateurs().get(i).getEmail()) && password.equals(AdminService.getFormateurs().get(i).getPassword())) {
                System.out.println("welcome");
                flag = true;
                indiceFormateur = i;
            }
        }
        return flag;
    }

    public void AddApprenant() {

        System.out.println("Voici la liste des apprenants");
        for (int i = 0; i < AdminService.getApprenants().size(); i++) {
                    System.out.println(AdminService.getApprenants().get(i));


        }
        for (int i = 0; i < AdminService.getPromotions().size(); i++) {
            if (AdminService.getPromotions().get(i).getFormateurName().equals(AdminService.getFormateurs().get(i).getLastname())) {
                System.out.println("entrer la list des apprenants sous forme de (1-2-3-4-5)");
                String[] list = scanner.next().split("-");
                for (String s : list) {
                    System.out.println(s);
                    AdminService.getPromotions().get(i).getStudents().add(AdminService.getApprenants().get(Integer.parseInt(s)));
                }
                AdminService.DisplayPromotion();
            } else {
                System.out.println("Ce formateur n'est pas créer");
            }
        }
    }

    public void AddBrief() {
        String briefTitle;
        String briefContext;
        System.out.println("Entrer le titre du brief");
        briefTitle = scanner.next();
        System.out.println("Enter la description du brief");
        briefContext = scanner.next();
        briefs.add(new Brief(briefTitle, briefContext, AdminService.getFormateurs().get(indiceFormateur)));
        System.out.println(briefs);
    }

    public void AssignBrief() {

        System.out.println("Voici la liste des briefs");
        //System.out.println(briefs);
        for (int i = 0; i < briefs.size(); i++) {
            if (AdminService.getFormateurs().get(indiceFormateur).equals(briefs.get(i).getFormateur())) {
                System.out.println(briefs.get(i));
            }
        }
        System.out.println("Entrer l'indice du brief(s) à distribuer sous forme de(0-1-2-3)");
        String[] listBriefs = scanner.next().split("-");
        for (int j = 0; j < AdminService.getPromotions().size(); j++) {
            if (AdminService.getFormateurs().get(indiceFormateur).getLastname().equals(AdminService.getPromotions().get(j).getFormateurName())) {
                for (int i = 0; i < listBriefs.length; i++) {
                    AdminService.getPromotions().get(i).getBriefs().add(briefs.get(Integer.parseInt(listBriefs[i])));
                    System.out.println(AdminService.getPromotions());
                    for (int m =0 ;m<AdminService.getPromotions().get(j).getStudents().size();m++){
                        SendingEmail.send(AdminService.getPromotions().get(j).getStudents().get(m).getEmail(),AdminService.getPromotions().get(j).getStudents().get(m).getFirstname(),AdminService.getPromotions().get(j).getStudents().get(m).getLastname(),briefs.get(Integer.parseInt(listBriefs[i])).getTitle());
                    }
                }

            }
        }


    }
}
