import java.util.ArrayList;

public class Promotion {


    private String promoName;
    private  ArrayList<Apprenant> students;
    private String formateurName;

    public Promotion(String promoName, String formateur,ArrayList<Apprenant> students){
        this.promoName= promoName;
        this.students= students;
        this.formateurName= formateur;
    }
    public Promotion(String promoName, String formateur){
        this.promoName= promoName;
        this.students= students;
        this.formateurName= formateur;
        this.students = new ArrayList<>();
    }
    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public String getFormateurName() {
        return formateurName;
    }

    public void setFormateurName(String formateur) {
        this.formateurName = formateur;
    }

    public ArrayList<Apprenant> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Apprenant> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return
                super.toString()+" Promotion{" +
                "promoName='" + promoName + '\'' +
                ", students=" + students +
                ", formateur='" + formateurName + '\'' +
                '}';
    }
}
