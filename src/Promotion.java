import java.util.ArrayList;

public class Promotion {


    private String promoName;
    private  ArrayList<Apprenant> students;
    private String formateurName;

    private  ArrayList<Brief> briefs;

    public Promotion(String promoName, String formateur,ArrayList<Apprenant> students){
        this.promoName= promoName;
        this.formateurName= formateur;
        this.students= students;
    }
    public Promotion(String promoName, String formateur,ArrayList<Apprenant> students, ArrayList<Brief> briefs){
        this.promoName= promoName;
        this.formateurName= formateur;
        this.students= students;
        this.briefs= briefs;

    }
    public Promotion(){

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
