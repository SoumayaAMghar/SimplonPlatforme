public class Brief {

    private String title;
    private String description;
    private Formateur formateur;

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Brief(String title, String description, Formateur formateur) {
        this.title = title;
        this.description = description;
        this.formateur= formateur;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Brief{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
