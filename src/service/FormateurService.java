package service;
import java.sql.SQLException;
import java.text.Format;
import java.util.Scanner;

import dao.*;
import login.Login;


public class FormateurService {
    public Cookie cookie = new Cookie();

    public static Scanner scanner = new Scanner(System.in);
    private int indiceformateur;
    private admin admin=new admin();
    private formateur formateur=new formateur();

    public boolean login() throws SQLException {
        System.out.println("entrer votre email");
        String email = scanner.next();
        System.out.println("entrer votre password");
        String password = scanner.next();
        formateur formateur = new formateur();
        return Login.login(email, password,"formateur");
    }

  public void addapprenant() throws SQLException {

        System.out.println("voici la liste des apprenants");
        admin.ApprenantsWithoutPromotion();
        System.out.println("entrer la list des apprenants sous forme de (1-2-3-4-5)");
        String[] list = scanner.next().split("-");
        formateur.addapprenant(list,cookie.getIdPromtion());
    }

     public void addbrief() throws SQLException {
        String brieftitle;
        String briefcontext;
        System.out.println("entrer le titre du brief");
        brieftitle = scanner.next();
        System.out.println("enter la description du brief");
        briefcontext = scanner.next();
        formateur.addbrief(brieftitle, briefcontext, cookie.getIdPromtion());

    }
    public void assignbrief() throws SQLException {
        formateur.Displaybriefs(cookie.getIdPromtion());
        System.out.println("entrer le id du brief");
        int idBrief = scanner.nextInt();
        formateur.UpdatebriefDislpay(idBrief);
        formateur.sendemail(idBrief,cookie.getIdPromtion());
    }

  /*  public void assignbrief() {

        system.out.println("voici la liste des briefs");
        //system.out.println(briefs);
        for (int i = 0; i < briefs.size(); i++) {
            if (adminservice.getformateurs().get(indiceformateur).equals(briefs.get(i).getformateur())) {
                system.out.println(briefs.get(i));
            }
        }
        system.out.println("entrer l'indice du brief(s) à distribuer sous forme de(0-1-2-3)");
        string[] listbriefs = scanner.next().split("-");
        for (int j = 0; j < adminservice.getpromotions().size(); j++) {
            if (adminservice.getformateurs().get(indiceformateur).getlastname().equals(adminservice.getpromotions().get(j).getformateurname())) {
                for (int i = 0; i < listbriefs.length; i++) {
                    adminservice.getpromotions().get(i).getbriefs().add(briefs.get(integer.parseint(listbriefs[i])));
                    system.out.println(adminservice.getpromotions());
                    for (int m = 0; m < adminservice.getpromotions().get(j).getstudents().size(); m++) {
                        sendingemail.send(adminservice.getpromotions().get(j).getstudents().get(m).getemail(), adminservice.getpromotions().get(j).getstudents().get(m).getfirstname(), adminservice.getpromotions().get(j).getstudents().get(m).getlastname(), briefs.get(integer.parseint(listbriefs[i])).gettitle());
                    }
                }

            }
        }


    }*/
}
