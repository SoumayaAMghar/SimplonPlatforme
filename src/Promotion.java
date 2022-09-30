import java.util.ArrayList;

public class Promotion {
    public String promoName;
    public ArrayList<Apprenant> students;
    public String formateur;

    public Promotion(String promoName, String formateur,ArrayList<Apprenant> students){
        this.promoName= promoName;
        this.students= students;
        this.formateur= formateur;
    }

    public void display(){
        System.out.println("formateur"+this.formateur);
        System.out.println("name"+this.promoName);
        for (Apprenant student : this.students) {
            student.display();
        }
    }
}
