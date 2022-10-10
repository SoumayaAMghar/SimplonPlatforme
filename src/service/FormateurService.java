package service;
import java.sql.SQLException;
import java.text.Format;
import java.util.Scanner;

import dao.admin;
import dao.formateur;

public class FormateurService {

    public static Scanner scanner = new Scanner(System.in);
    private int indiceformateur;

    public boolean login() throws SQLException {
        System.out.println("entrer votre email");
        String email = scanner.next();
        System.out.println("entrer votre password");
        String password = scanner.next();
        formateur formateur = new formateur();
        return formateur.login(email, password);
    }

    /*public void addapprenant() {

        System.out.println("voici la liste des apprenants");
        for (int i = 0; i < adminservice.getapprenants().size(); i++) {
            System.out.println(adminservice.getapprenants().get(i));


        }
        for (int i = 0; i < adminservice.getpromotions().size(); i++) {
            if (adminservice.getpromotions().get(i).getformateurname().equals(adminservice.getformateurs().get(i).getlastname())) {
                system.out.println("entrer la list des apprenants sous forme de (1-2-3-4-5)");
                string[] list = scanner.next().split("-");
                for (string s : list) {
                    system.out.println(s);
                    adminservice.getpromotions().get(i).getstudents().add(adminservice.getapprenants().get(integer.parseint(s)));
                }
                adminservice.displaypromotion();
            } else {
                system.out.println("ce formateur n'est pas créer");
            }
        }
    }

    public void addbrief() {
        string brieftitle;
        string briefcontext;
        system.out.println("entrer le titre du brief");
        brieftitle = scanner.next();
        system.out.println("enter la description du brief");
        briefcontext = scanner.next();
        briefs.add(new brief(brieftitle, briefcontext, adminservice.getformateurs().get(indiceformateur)));
        system.out.println(briefs);
    }

    public void assignbrief() {

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
